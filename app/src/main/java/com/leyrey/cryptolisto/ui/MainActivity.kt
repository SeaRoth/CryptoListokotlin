package com.leyrey.cryptolisto.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.leyrey.cryptolisto.R
import com.leyrey.cryptolisto.data.remote.coinMarketCapModel.CoinMarketCapCoin
import com.leyrey.cryptolisto.domain.dto.CoinsDTO
import com.leyrey.cryptolisto.ui.adapters.CoinsListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.parceler.Parcels

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val coinsDTO = Parcels.unwrap<CoinsDTO>(intent.getParcelableExtra(getString(R.string.intentCoinsListParceBundleName)))
        setRecyclerView(coinsDTO)
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
}
