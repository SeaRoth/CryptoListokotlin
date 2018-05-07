package com.leyrey.cryptolisto.data.room

import android.arch.persistence.room.*
import android.content.Context

@Database(entities = arrayOf(CoinEntity::class), version = 1)
abstract class RoomDataSource : RoomDatabase() {

    abstract fun coinSearchDao(): CoinsDao

    companion object {

        @Volatile private var INSTANCE: RoomDataSource? = null

        fun getInstance(context: Context): RoomDataSource =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        RoomDataSource::class.java, RoomConfig.DATABASE_COINMARKETCAP)
                        .build()
    }
}