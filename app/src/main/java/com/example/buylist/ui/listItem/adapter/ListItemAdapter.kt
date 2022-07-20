package com.example.buylist.ui.listItem.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.buylist.base.BaseListAdapter
import com.example.buylist.databinding.ItemRowBinding
import com.example.buylist.domain.uimodel.ListItemUIModel
import com.example.buylist.utils.extensions.orFalse

class ListItemAdapter :
    BaseListAdapter<ListItemUIModel>(itemsSame = { old, new -> old.uid == new.uid },
        contentsSame = { old, new -> old == new }) {

    inner class ListItemViewHolder(private val binding: ItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(uiModel: ListItemUIModel) {
            binding.apply {
                tvItem.text = uiModel.name
                textViewItemQuantity.text = uiModel.quantity.toString()
                checkBox.isChecked = uiModel.completed.orFalse()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ListItemViewHolder -> {
                getItem(position)?.let { holder.bind(it) }
            }
        }
    }
}