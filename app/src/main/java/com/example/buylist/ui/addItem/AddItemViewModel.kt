package com.example.buylist.ui.addItem

import android.util.Log
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buylist.R
import com.example.buylist.data.local.ListItem
import com.example.buylist.data.local.ListItemDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddItemViewModel @Inject constructor(private val itemDao: ListItemDao) :
    ViewModel() {

    sealed class Event {
        //object NavigateToSettings : Event()
        object PopBackStack : Event()

        //data class ShowSnackBar(val text: String): Event()
        data class ShowToast(@StringRes val textResId: Int) : Event()
    }

    private val eventChannel = Channel<Event>(Channel.BUFFERED)
    val eventsFlow = eventChannel.receiveAsFlow()

    fun addItem(name: String, completed: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            when {
                name.isBlank() -> { // check if name is blank
                    eventChannel.send(Event.ShowToast(R.string.alert_name_blank))
                }
                /*quantity.toString().isBlank() -> { // check if name is blank
                    eventChannel.send(Event.ShowToast(R.string.alert_quantity_blank))
                }
                quantity.toString().isBlank() && name.isBlank() -> { // check if name is blank
                    eventChannel.send(Event.ShowToast(R.string.alert_all_fields_blank))
                }*/
                else -> {
                    itemDao.insert(
                        ListItem(
                            name = name,
                            completed = completed
                        )
                    )
                    eventChannel.send(Event.PopBackStack)
                }
            }
        }
        Log.v("AddItemViewModel", "name : $name")
    }
}