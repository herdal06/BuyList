package com.example.buylist.ui.listItem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.buylist.R
import com.example.buylist.databinding.FragmentListItemBinding
import com.example.buylist.ui.listItem.adapter.ItemDecorator
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
        //viewModel.getAllListItems()
    }

    private fun observe() {
        lifecycleScope.launchWhenCreated {
            viewModel.uiState.collect {
                setUIState(it)
            }
        }
        // update fragment with resultListener
        /*setFragmentResultListener("requestKey") { _, _ ->
            viewModel.getAllListItems()
        }
         */
    }

    private fun setUIState(uiState: ItemListViewModel.UiState) {
        listItemAdapter.submitList(uiState.items)
    }

    private fun initUI() {

        binding.apply {
            recyclerViewListItems.adapter = listItemAdapter
            recyclerViewListItems.addItemDecoration(ItemDecorator(requireContext())) // requireContext() -> context won't null
            recyclerViewListItems.addItemDecoration(
                DividerItemDecoration(
                    recyclerViewListItems.context,
                    DividerItemDecoration.VERTICAL
                )
            )
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