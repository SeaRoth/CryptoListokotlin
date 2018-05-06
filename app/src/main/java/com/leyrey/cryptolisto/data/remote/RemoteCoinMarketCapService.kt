package com.leyrey.cryptolisto.data.remote

import com.leyrey.cryptolisto.data.remote.coinMarketCapModel.CoinMarketCapCoin
import com.leyrey.cryptolisto.data.remote.coinMarketCapModel.CoinMarketCapResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RemoteCoinMarketCapService{
    @GET("{length}")
    fun requestCoinListWithSize(
            @Path("length") length: String
    ) : Single<CoinMarketCapResponse>

    @GET("json")
fun requestCoinById(
            @Query("id") id: String
    ): Single<CoinMarketCapCoin>

}