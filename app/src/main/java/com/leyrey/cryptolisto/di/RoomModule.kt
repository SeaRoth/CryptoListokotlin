package com.leyrey.cryptolisto.di

import android.content.Context
import com.leyrey.cryptolisto.data.room.RoomDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule{
    @Provides
    @Singleton
    fun provideRoomCurrencyDataSource(context: Context){
        RoomDataSource.getInstance(context)
    }
}