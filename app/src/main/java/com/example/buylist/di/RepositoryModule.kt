package com.example.buylist.di

import com.example.buylist.data.local.ListItemDao
import com.example.buylist.data.repository.ListItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    fun provideListItemRepository(
        itemDao: ListItemDao
    ): ListItemRepository {
        return ListItemRepository(itemDao)
    }
}