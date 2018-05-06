package com.leyrey.cryptolisto.domain.dto

import com.leyrey.cryptolisto.data.remote.coinMarketCapModel.CoinMarketCapCoin
import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel(Parcel.Serialization.BEAN)
data class CoinsDTO @ParcelConstructor constructor(
        val coins: ArrayList<CoinMarketCapCoin>
)