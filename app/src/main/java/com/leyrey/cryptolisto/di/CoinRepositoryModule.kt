package com.leyrey.cryptolisto.di

import com.leyrey.cryptolisto.data.repository.CoinMarketCapRepository
import com.leyrey.cryptolisto.data.repository.CoinMarketCapRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class CoinRepositoryModule{
    @Binds
    abstract fun bindsCoinRepository(coinMarketCapRepositoryImpl: CoinMarketCapRepositoryImpl): CoinMarketCapRepository
}