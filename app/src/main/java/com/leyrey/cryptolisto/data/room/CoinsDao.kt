package com.leyrey.cryptolisto.data.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.leyrey.cryptolisto.data.remote.coinMarketCapModel.CoinMarketCapCoin
import io.reactivex.Flowable

@Dao
interface CoinsDao{
    @Insert
    fun insertAll(coins: List<CoinMarketCapCoin>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCoin(coin: CoinMarketCapCoin)

    @Query(RoomConfig.SELECT_COINS)
    fun getAllCoins(): Flowable<List<CoinMarketCapCoin>>
}