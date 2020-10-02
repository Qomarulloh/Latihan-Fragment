package com.example.android.tugasfragmentqomar

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.tugasfragmentqomar.databinding.FragmentNamaBinding
import com.example.android.tugasfragmentqomar.databinding.FragmentUsiaBinding

class UsiaFragment : Fragment() {
    private lateinit var viewModel: SharedViewModel
    private lateinit var binding: FragmentUsiaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_usia, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        viewModel.eventNextJk.observe(requireActivity(), Observer {
            if (it){
                viewModel.updateUsia(
                    binding.etUsia.text.toString()
                )
                this.findNavController().navigate(R.id.action_usiaFragment_to_jenisKelaminFragment)
                viewModel.onNextJkComplete()
            }
        })

        binding.viewModel = viewModel
        return binding.root
    }
}
