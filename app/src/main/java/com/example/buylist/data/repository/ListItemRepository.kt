package com.example.buylist.data.repository

import com.example.buylist.data.local.ListItemDao
import com.example.buylist.domain.mapper.ListItemMapper
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ListItemRepository @Inject constructor(
    private val itemDao: ListItemDao
) {
    operator fun invoke() = itemDao.getAll().map { itemList ->
        itemList.map {
            ListItemMapper.map(it)
        }
    }
}