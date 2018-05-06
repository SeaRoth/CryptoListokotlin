package com.leyrey.cryptolisto.di

import android.app.Application

class CoinApplication : Application(){
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate(){
        super.onCreate()
        initializeDagger()
    }

    fun initializeDagger(){
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .roomModule(RoomModule())
                .remoteModule(RemoteModule()).build()
    }
}