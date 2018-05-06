package com.leyrey.cryptolisto.data.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = RoomConfig.TABLE_COINS)
data class CoinEntity(
        @PrimaryKey(autoGenerate = true) val id: Int = 0,
        var symbol: String
)


