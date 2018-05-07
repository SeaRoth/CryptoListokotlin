package com.leyrey.cryptolisto.data.repository

import com.leyrey.cryptolisto.data.remote.coinMarketCapModel.CoinMarketCapCoin
import com.leyrey.cryptolisto.data.room.CoinEntity
import com.leyrey.cryptolisto.domain.dto.CoinListDTO
import io.reactivex.Flowable
import io.reactivex.Single

interface CoinMarketCapRepository{
    fun getCoins(): Single<CoinListDTO>

    fun getCoin(id: String): Single<CoinMarketCapCoin>?
}