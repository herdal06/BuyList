package com.example.buylist.ui.addItem

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buylist.data.local.AppDatabase
import com.example.buylist.data.local.ListItem
import com.example.buylist.data.repository.ListItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddItemViewModel @Inject constructor(private val appDatabase: AppDatabase) :
    ViewModel() {

    fun addItem(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            appDatabase.listItemDao().insert(
                ListItem(
                    name = name,
                )
            )
        }
        Log.v("AddItemViewModel","name : $name")
    }
}