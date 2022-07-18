package com.example.buylist.ui.listItem.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.buylist.databinding.ItemRowBinding
import com.example.buylist.domain.uimodel.ListItemUIModel

class ListItemViewHolder(
    view: View
) :
    RecyclerView.ViewHolder(view) {
    private val binding = ItemRowBinding.bind(view)

    fun bind(uiModel: ListItemUIModel) = with(binding) {
        tvWeight.text = uiModel.name

    }
}