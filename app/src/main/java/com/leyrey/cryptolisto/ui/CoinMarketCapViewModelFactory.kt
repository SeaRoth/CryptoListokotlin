package com.leyrey.cryptolisto.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.leyrey.cryptolisto.data.repository.CoinMarketCapRepository
import javax.inject.Inject

class CoinMarketCapViewModelFactory @Inject constructor(val coinMarketCapRepository: CoinMarketCapRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(CoinMarketCapViewModel::class.java)){
            return CoinMarketCapViewModel(coinMarketCapRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class bruh")
    }
}