package com.leyrey.cryptolisto.ui

import android.arch.lifecycle.ViewModel
import com.leyrey.cryptolisto.data.repository.CoinMarketCapRepository
import org.parceler.Repository
import javax.inject.Inject

class CoinMarketCapViewModel @Inject constructor(val coinRepository: CoinMarketCapRepository) : ViewModel() {

    fun getCoins() = coinRepository.getCoins()

    fun getCoinDetails(id: String) = coinRepository.getCoin(id)



}