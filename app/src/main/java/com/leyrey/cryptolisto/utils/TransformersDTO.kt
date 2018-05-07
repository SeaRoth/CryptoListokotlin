package com.leyrey.cryptolisto.utils
import com.leyrey.cryptolisto.data.remote.coinMarketCapModel.CoinMarketCapResponse
import com.leyrey.cryptolisto.domain.dto.CoinDetailsDTO
import java.util.*


object TransformersDTO{
    fun transformToWeatherDetailsDTO(coinName: String, coinResponse: CoinMarketCapResponse?): CoinDetailsDTO {
        return CoinDetailsDTO(
                id = coinResponse!!.data[0].id,
            name = coinName
        )
    }
}