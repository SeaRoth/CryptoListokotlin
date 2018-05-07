package com.leyrey.cryptolisto.ui

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork
import com.jakewharton.rxbinding2.widget.RxTextView
import com.leyrey.cryptolisto.R
import com.leyrey.cryptolisto.R.id.*
import com.leyrey.cryptolisto.data.remote.coinMarketCapModel.CoinMarketCapCoin
import com.leyrey.cryptolisto.data.room.CoinEntity
import com.leyrey.cryptolisto.di.CoinApplication
import com.leyrey.cryptolisto.domain.dto.CoinsDTO
import com.leyrey.cryptolisto.ui.adapters.CoinsListAdapter
import com.leyrey.cryptolisto.utils.InputValidator.isValidCoinInput
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.parceler.Parcels
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private var TAG = "MainActivity"

    @Inject
    lateinit var viewModelFactory: CoinMarketCapViewModelFactory
    private lateinit var viewModel: CoinMarketCapViewModel
    private var isConnectedToInternet: Boolean = false
    private var _coinNames = ArrayList<String>()
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onStart() {
        super.onStart()
        compositeDisposable.add(setupSearchCoinsObserver())
        compositeDisposable.add(setupInternetConnectionObserver())

    }

    override fun onStop() {
        super.onStop()
        compositeDisposable.clear()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoinApplication.appComponent.inject(this)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(CoinMarketCapViewModel::class.java)



        val coinsDTO = Parcels.unwrap<CoinsDTO>(intent.getParcelableExtra(getString(R.string.intentCoinsListParceBundleName)))
        setRecyclerView(coinsDTO)

        val itemInputNameObservable = RxTextView.textChanges(autocomplete_textView)
                .map { inputText: CharSequence -> inputText.isEmpty() || !isValidCoinInput(inputText.toString()) }
                .distinctUntilChanged()
        compositeDisposable.add(setupTextInputObserver(itemInputNameObservable))

        setupSearchListener()
    }

    private fun setRecyclerView(ourDTO: CoinsDTO){
        val coinList = ourDTO.coins as ArrayList<CoinMarketCapCoin>
        val adapter: CoinsListAdapter? = CoinsListAdapter(coinList)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerViewCoinList.layoutManager = mLayoutManager
        recyclerViewCoinList.itemAnimator = DefaultItemAnimator()
        recyclerViewCoinList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerViewCoinList.adapter = adapter
    }

    private fun setupSearchListener() {
        search_button.setOnClickListener {
            if (!isConnectedToInternet) {
                Toast.makeText(this, getString(R.string.no_internet), Toast.LENGTH_SHORT).show()
            }
            else{
                processRequestStartUI()
                //val searchedCityName = autocomplete_textView.text.toString()
                setupSearchCoinsObserver()?.let { it -> compositeDisposable.add(it) }
            }
        }
    }

    private fun setupTextInputObserver(itemInputNameObservable: Observable<Boolean>): Disposable {
        return itemInputNameObservable.subscribe { inputIsEmpty: Boolean ->
            til_autocomplete.error = getString(R.string.invalid_input)
            til_autocomplete.isErrorEnabled = inputIsEmpty
            search_button?.isEnabled = !inputIsEmpty
        }
    }

    private fun processRequestStartUI() {
        ll_search_coins.isEnabled = false
        ll_search_coins.alpha = 0.5f
        progressBar.visibility = View.VISIBLE
    }

    private fun resolveRequestEndUI() {
        ll_search_coins.isEnabled = true
        ll_search_coins.alpha = 1f
        progressBar.visibility = View.INVISIBLE
    }

    private fun setupSearchCoinsObserver(): Disposable {
        return viewModel.getCoins()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                    { coins: List<CoinEntity>? ->
                        _coinNames.clear()
                        coins!!.forEach { _coinNames.add(it.symbol) }
                        Log.i(TAG, "I think we have the coins")
                        resolveRequestEndUI()
                    },
                    { throwable: Throwable? ->
                        resolveRequestEndUI()
                        if (!isConnectedToInternet) {
                            Toast.makeText(this, getString(R.string.no_internet), Toast.LENGTH_SHORT).show()
                        } else {
                            throwable?.printStackTrace()
                            Toast.makeText(this, getString(R.string.error_fetching), Toast.LENGTH_SHORT).show()
                        }
                    }
            )
    }

    private fun setupInternetConnectionObserver(): Disposable {
        return ReactiveNetwork.observeInternetConnectivity()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                    { isConnected: Boolean? ->
                        isConnected?.let {
                            if (!isConnected)
                                Toast.makeText(this, getString(R.string.no_internet), Toast.LENGTH_SHORT).show()
                            isConnectedToInternet = isConnected
                        }
                    },
                    { t: Throwable? ->
                        Log.v("ReactiveNetwork", t?.message)
                    }
            )
    }

}
