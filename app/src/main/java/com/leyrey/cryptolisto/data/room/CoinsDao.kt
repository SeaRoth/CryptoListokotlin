package com.leyrey.cryptolisto.data.room

import android.arch.persistence.room.*
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