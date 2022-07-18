package com.example.buylist.ui.listItem.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.buylist.databinding.ItemRowBinding
import com.example.buylist.domain.uimodel.ListItemUIModel
import com.example.buylist.utils.extensions.orFalse

class ListItemViewHolder(
    view: View
) :
    RecyclerView.ViewHolder(view) {
    private val binding = ItemRowBinding.bind(view)

    fun bind(uiModel: ListItemUIModel) = with(binding) {
        tvItem.text = uiModel.name
        textViewItemQuantity.text = uiModel.quantity.toString()
        checkBox.isChecked = uiModel.completed.orFalse()
    }
}