package com.leyrey.cryptolisto.domain.dto

import com.leyrey.cryptolisto.data.remote.coinMarketCapModel.CoinMarketCapCoin
import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel(Parcel.Serialization.BEAN)
data class CoinListDTO @ParcelConstructor constructor(val coins: List<CoinMarketCapCoin>)