package com.example.android.tugasfragmentqomar

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.tugasfragmentqomar.databinding.FragmentJenisKelaminBinding

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [JenisKelaminFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [JenisKelaminFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class JenisKelaminFragment : Fragment() {
    private lateinit var viewModel: SharedViewModel
    private lateinit var binding: FragmentJenisKelaminBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_jenis_kelamin, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        viewModel.eventNextHasil.observe(requireActivity(), Observer {
            if (it){
                viewModel.jk.observe(requireActivity(), Observer {
                    when(it) {
                        binding.rbLakilaki.id -> viewModel.updateJkText(binding.rbLakilaki.text.toString())
                        binding.rbPerempuan.id -> viewModel.updateJkText(binding.rbPerempuan.text.toString())
                    }
                })
                this.findNavController().navigate(R.id.action_jenisKelaminFragment_to_hasilFragment)
                viewModel.onNextHasilComplete()
            }
        })

        binding.viewModel = viewModel

        binding.radioGroup.setOnCheckedChangeListener { _, i ->
            viewModel.updateJk(i)
        }


        return binding.root
    }
}
