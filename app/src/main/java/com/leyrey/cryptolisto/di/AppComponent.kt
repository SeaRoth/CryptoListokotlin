package com.leyrey.cryptolisto.di

import com.leyrey.cryptolisto.ui.MainActivity
import dagger.Component
import javax.inject.Singleton


@Component(modules = arrayOf(AppModule::class, RemoteModule::class, RoomModule::class, CoinRepositoryModule::class))
@Singleton
interface AppComponent {

    fun inject(weatherSearchActivity: MainActivity)
}