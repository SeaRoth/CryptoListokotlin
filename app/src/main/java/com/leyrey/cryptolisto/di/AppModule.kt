package com.leyrey.cryptolisto.di

import android.content.Context
import com.leyrey.cryptolisto.data.repository.CoinMarketCapRepository
import com.leyrey.cryptolisto.ui.CoinMarketCapViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val coinApplication: CoinApplication){
    @Provides
    @Singleton
    fun provideContext(): Context = coinApplication

    @Provides
    @Singleton
    fun provideViewModelFactory(coinMarketCapRepository: CoinMarketCapRepository) : CoinMarketCapViewModelFactory{
        return CoinMarketCapViewModelFactory(coinMarketCapRepository)
    }
}