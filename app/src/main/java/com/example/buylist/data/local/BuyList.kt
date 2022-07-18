package com.example.buylist.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "buy_list")
data class BuyList(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "items")
    val items: List<ListItem>,
    @ColumnInfo(name = "completed")
    val completed: Boolean?,
)
