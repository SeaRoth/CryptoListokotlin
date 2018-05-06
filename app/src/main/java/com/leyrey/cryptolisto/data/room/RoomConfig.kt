package com.leyrey.cryptolisto.data.room

class RoomConfig {
    companion object {
        const val DATABASE_COINMARKETCAP = "coinmarketcap.db"
        const val TABLE_COINS = "coins"

        private const val SELECT_FROM = "SELECT * FROM "

        const val SELECT_COINS = SELECT_FROM + TABLE_COINS
    }
}