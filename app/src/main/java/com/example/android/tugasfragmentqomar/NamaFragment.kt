package com.example.android.tugasfragmentqomar

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.tugasfragmentqomar.databinding.FragmentNamaBinding

class NamaFragment : Fragment() {
    private lateinit var viewModel: SharedViewModel
    private lateinit var binding: FragmentNamaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_nama, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        viewModel.eventNextUsia.observe(requireActivity(), Observer {
            if (it){
                viewModel.updateNama(
                    binding.etNama.text.toString()
                )
                this.findNavController().navigate(R.id.action_namaFragment_to_usiaFragment)
                viewModel.onNextUsiaComplete()
            }
        })

        binding.viewModel = viewModel
        return binding.root
    }
}
