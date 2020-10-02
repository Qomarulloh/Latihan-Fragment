package com.example.android.tugasfragmentqomar

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.tugasfragmentqomar.databinding.FragmentHasilBinding
import kotlinx.android.synthetic.main.fragment_hasil.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HasilFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HasilFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HasilFragment : Fragment() {
    private lateinit var viewModel: SharedViewModel
    private lateinit var binding: FragmentHasilBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_hasil, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        binding.data = viewModel.myData.value

        viewModel.eventBack.observe(requireActivity(), Observer {
            if (it){

                this.findNavController().navigate(R.id.action_hasilFragment_to_jenisKelaminFragment)
                viewModel.onBackComplete()
            }
        })
        binding.viewModel = viewModel

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share -> {
                val intent = Intent(Intent.ACTION_SEND)
                intent.setType("text/plain")
                intent.putExtra(Intent.EXTRA_TEXT, "Data 1: ${arguments?.getInt("data1")}")
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
