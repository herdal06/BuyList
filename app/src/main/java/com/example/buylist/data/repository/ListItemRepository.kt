package com.example.buylist.data.repository

import com.example.buylist.data.local.AppDatabase
import com.example.buylist.domain.mapper.ListItemMapper
import javax.inject.Inject

class ListItemRepository @Inject constructor(
    private val appDatabase: AppDatabase
) {
    operator fun invoke() = appDatabase.listItemDao().getAll().map {
        ListItemMapper.map(it)
    }
}