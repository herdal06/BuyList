package com.example.buylist.data.local

import androidx.room.*

@Dao
interface ListItemDao {
    @Query("SELECT * FROM list_item")
    fun getAll(): List<ListItem>

    @Insert
    fun insertAll(vararg items: ListItem)

    @Insert
    suspend fun insert(item: ListItem)

    @Delete
    fun delete(item: ListItem)

    @Update
    fun update(item: ListItem)
}