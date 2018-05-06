package com.leyrey.cryptolisto.data.repository

import com.leyrey.cryptolisto.data.remote.RemoteCoinMarketCapDataSource
import com.leyrey.cryptolisto.data.remote.RemoteCoinMarketCapService
import com.leyrey.cryptolisto.data.remote.coinMarketCapModel.CoinMarketCapCoin
import com.leyrey.cryptolisto.data.remote.coinMarketCapModel.CoinMarketCapResponse
import com.leyrey.cryptolisto.data.room.RoomDataSource
import com.leyrey.cryptolisto.domain.dto.CoinsDTO
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CoinMarketCapRepositoryImpl @Inject constructor(
        private val remoteCoinMarketCapDataSource: RemoteCoinMarketCapDataSource,
        private val roomDataSource: RoomDataSource
) : CoinMarketCapRepository {

    override fun getCoin(id: String): Single<CoinsDTO>? {
        return null
//        return remoteCoinMarketCapDataSource.requestCoinById(id)
//                .map ({ coinMarketCapResponse: CoinMarketCapResponse ->
//
//
//                }).retry(1)
    }

    override fun getCoins(): Flowable<List<CoinMarketCapCoin>> {
        return roomDataSource.coinSearchDao().getAllCoins()
    }




}