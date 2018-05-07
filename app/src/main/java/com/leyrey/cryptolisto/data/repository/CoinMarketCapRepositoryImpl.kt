package com.leyrey.cryptolisto.data.repository

import com.leyrey.cryptolisto.data.remote.RemoteCoinMarketCapDataSource
import com.leyrey.cryptolisto.data.room.CoinEntity
import com.leyrey.cryptolisto.data.room.RoomDataSource
import com.leyrey.cryptolisto.domain.dto.CoinDetailsDTO
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CoinMarketCapRepositoryImpl @Inject constructor(
        private val remoteCoinMarketCapDataSource: RemoteCoinMarketCapDataSource,
        private val roomDataSource: RoomDataSource
) : CoinMarketCapRepository {

    override fun getCoin(id: String): Single<CoinDetailsDTO>? {
        return null
//        return remoteCoinMarketCapDataSource.requestCoinById(id)
//                .map ({ coinMarketCapResponse: CoinMarketCapResponse ->
//
//
//                }).retry(1)
    }

    override fun getCoins(): Flowable<List<CoinEntity>> {
        //return roomDataSource.coinSearchDao().getAllCoins()




    }




}