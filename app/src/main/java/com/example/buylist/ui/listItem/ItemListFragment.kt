package com.example.buylist.ui.listItem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.buylist.R
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
        ListItemAdapter()
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
        viewModel.getAllListItems()
    }

    private fun observe() {
        lifecycleScope.launchWhenCreated {
            viewModel.uiState.collect {
                setUIState(it)
            }
        }
    }

    private fun setUIState(uiState: ItemListViewModel.UiState) {
        listItemAdapter.submitList(uiState.items)
    }

    private fun initUI() {
        binding.recyclerViewListItems.adapter = listItemAdapter
        binding.apply {
            fabAddItem.setOnClickListener {
                findNavController().navigate(R.id.action_itemListFragment_to_addItemFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}