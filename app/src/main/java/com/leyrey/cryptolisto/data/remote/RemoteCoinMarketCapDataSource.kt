package com.leyrey.cryptolisto.data.remote

import com.leyrey.cryptolisto.data.remote.coinMarketCapModel.CoinMarketCapCoin
import com.leyrey.cryptolisto.data.remote.coinMarketCapModel.CoinMarketCapResponse
import io.reactivex.Single
import javax.inject.Inject

class RemoteCoinMarketCapDataSource @Inject constructor(private val remoteCoinMarketCapService: RemoteCoinMarketCapService){
    fun requestCoins(): Single<CoinMarketCapResponse> =
            remoteCoinMarketCapService.requestCoinListWithSize("10")

    fun requestCoinById(id: String): Single<CoinMarketCapCoin> = remoteCoinMarketCapService.requestCoinById(id)
}