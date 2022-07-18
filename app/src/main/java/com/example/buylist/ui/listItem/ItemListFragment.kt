package com.example.buylist.ui.listItem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.buylist.databinding.FragmentListItemBinding
import com.example.buylist.domain.uimodel.ListItemUIModel
import com.example.buylist.ui.listItem.adapter.ListItemAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemListFragment : Fragment() {

    private var _binding: FragmentListItemBinding? = null
    private val viewModel: ItemListViewModel by viewModels()
    private val binding get() = _binding!!
    private val listItemAdapter: ListItemAdapter by lazy {
        ListItemAdapter(::onClickItem)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListItemBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        observe()
    }

    private fun observe() {

    }

    private fun initUI() {
        binding.apply {
            recyclerViewListItems.adapter = listItemAdapter.apply {
                //submitList(listOf(ListItemUIModel()))
            }
        }
    }

    private fun onClickItem(item: ListItemUIModel) {

    }
}