package com.example.buylist.ui.buyList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.buylist.R
import com.example.buylist.databinding.FragmentBuyListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BuyListFragment : Fragment() {

    private var _binding: FragmentBuyListBinding? = null
    private val viewModel: BuyListViewModel by viewModels()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBuyListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}