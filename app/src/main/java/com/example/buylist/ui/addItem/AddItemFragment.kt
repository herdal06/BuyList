package com.example.buylist.ui.addItem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.buylist.databinding.FragmentAddItemBinding
import com.example.buylist.utils.extensions.showToast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddItemFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentAddItemBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel: AddItemViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        observe()
    }

    private fun observe() {
        lifecycleScope.launchWhenStarted {
            viewModel.eventsFlow
                .collect { event ->
                    when (event) {
                        AddItemViewModel.Event.PopBackStack -> {
                            // Use the Kotlin extension in the fragment-ktx artifact
                            setFragmentResult("requestKey", bundleOf())
                            //findNavController().popBackStack()
                        }
                        //is AddItemViewModel.Event.ShowSnackBar -> {}
                        is AddItemViewModel.Event.ShowToast -> {
                            context.showToast(event.textResId)
                        }
                    }
                }
        }
    }

    private fun initUI() = with(binding) {
        btnSave.setOnClickListener {
            val name = tilInputName.text.toString()
            viewModel.addItem(name = name, completed = false)
            //Log.v("AddItemFragment","name : $name")
            //findNavController().popBackStack() // or dismiss() -> close bottom sheet.
        }
    }
}