package com.example.buylist.ui.listItem

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buylist.data.repository.ListItemRepository
import com.example.buylist.domain.uimodel.ListItemUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemListViewModel @Inject constructor(private var repository: ListItemRepository) :
    ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    init {
        getAllListItems()
    }


    private fun getAllListItems() = viewModelScope.launch(Dispatchers.IO) {
        repository.invoke().collectLatest { itemList ->
            _uiState.update {
                it.copy(items = itemList)
            }
        }
    }

    data class UiState(
        var items: List<ListItemUIModel> = emptyList()
    )
}