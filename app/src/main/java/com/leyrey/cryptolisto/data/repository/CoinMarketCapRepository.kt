package com.leyrey.cryptolisto.data.repository

import com.leyrey.cryptolisto.data.room.CoinEntity
import com.leyrey.cryptolisto.domain.dto.CoinDetailsDTO
import io.reactivex.Flowable
import io.reactivex.Single

interface CoinMarketCapRepository{
    fun getCoins(): Flowable<List<CoinEntity>>

    fun getCoin(id: String): Single<CoinDetailsDTO>?
}