package com.leyrey.cryptolisto.domain.dto

import com.leyrey.cryptolisto.data.remote.coinMarketCapModel.CoinMarketCapCoin
import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel(Parcel.Serialization.BEAN)
data class CoinDetailsDTO @ParcelConstructor constructor(val id: Int,
                                                         val name: String
)

