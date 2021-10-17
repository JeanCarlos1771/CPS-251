package com.example.add_name_data

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.add_name_data.databinding.MainFragmentBinding

class MainFragment : Fragment() {
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

        if(viewModel.nameList.isEmpty()){

        }else{
            binding.textView.text = viewModel.nameList
        }

        binding.button2.setOnClickListener{
            if(binding.editTextTextPersonName2.text.isNotEmpty()){
                viewModel.storeNames(binding.editTextTextPersonName2.text.toString())
                for (element in viewModel.names){
                    viewModel.nameList += element+"\n"
                    viewModel.names.remove(element)
                }
            }else{
                binding.textView.text = "no value"
            }
            binding.textView.text = viewModel.nameList
        }

    }

}