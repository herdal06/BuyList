package com.example.buylist.domain.mapper

import com.example.buylist.data.local.ListItem
import com.example.buylist.domain.uimodel.ListItemUIModel

object ListItemMapper {
    fun map(entity: ListItem): ListItemUIModel {
        return ListItemUIModel(
            uid = entity.id,
            name = entity.name.orEmpty()
        )
    }
}