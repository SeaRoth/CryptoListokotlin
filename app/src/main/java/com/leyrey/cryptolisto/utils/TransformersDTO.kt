package com.leyrey.cryptolisto.utils
import com.leyrey.cryptolisto.data.remote.coinMarketCapModel.CoinMarketCapResponse
import com.leyrey.cryptolisto.domain.dto.CoinListDTO


object TransformersDTO{
    fun transformToCoinListDTO(coinResponse: CoinMarketCapResponse?): CoinListDTO {
        return CoinListDTO(
                coins = coinResponse!!.data
        )
    }
}