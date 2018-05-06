package com.leyrey.cryptolisto.data.remote.coinMarketCapModel

data class CoinMarketCapResponse(
        val coins: List<CoinMarketCapCoin>
)

data class CoinMarketCapCoin(
        val id: Int,
        var name: String,
        val symbol: String,
        val website_slug: String,
        val rank: Int,
        val circulating_supply: Int,
        val total_supply: Int,
        val max_supply: Int,
        val quotes: List<Quote>,
        val last_updated: Int
)

data class Quote(
        val currency: Currency
)

data class Currency(
        val price: Double,
        val volume_24h: Int,
        val market_cap: Int,
        val percent_change_1h: Double,
        val percent_change_24h: Double,
        val percent_change_7d: Double
)