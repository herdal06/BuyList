package com.example.buylist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BuyList::class, ListItem::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun listItemDao(): ListItemDao
}