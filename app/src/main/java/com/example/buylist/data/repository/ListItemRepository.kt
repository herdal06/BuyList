package com.example.buylist.data.repository

import com.example.buylist.data.local.ListItemDao
import com.example.buylist.domain.mapper.ListItemMapper
import com.example.buylist.domain.uimodel.ListItemUIModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ListItemRepository @Inject constructor(
    private val itemDao: ListItemDao
) {
    operator fun invoke(): Flow<List<ListItemUIModel>> = itemDao.getAll().map { itemList ->
        itemList.map {
            ListItemMapper.map(it)
        }
    }
}