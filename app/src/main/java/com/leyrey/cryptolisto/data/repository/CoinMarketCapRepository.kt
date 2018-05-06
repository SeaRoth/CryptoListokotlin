package com.leyrey.cryptolisto.data.repository

import com.leyrey.cryptolisto.data.remote.coinMarketCapModel.CoinMarketCapCoin
import com.leyrey.cryptolisto.domain.dto.CoinsDTO
import io.reactivex.Flowable
import io.reactivex.Single

interface CoinMarketCapRepository{
    fun getCoins(): Flowable<List<CoinMarketCapCoin>>

    fun getCoin(id: String): Single<CoinsDTO>?
}