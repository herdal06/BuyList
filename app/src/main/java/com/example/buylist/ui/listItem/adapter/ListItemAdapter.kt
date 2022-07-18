package com.example.buylist.ui.listItem.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.buylist.R
import com.example.buylist.base.BaseListAdapter
import com.example.buylist.domain.uimodel.ListItemUIModel

class ListItemAdapter(private val onClickItem: ((item: ListItemUIModel) -> Unit)?) :
    BaseListAdapter<ListItemUIModel>(
        itemsSame = { old, new -> old.uid == new.uid },
        contentsSame = { old, new -> old == new }
    ) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ListItemViewHolder(view, onClickItem)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ListItemViewHolder -> {
                holder.bind(getItem(position))
            }
        }
    }
}