package com.example.navigation_project.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigation_project.databinding.MainFragmentBinding

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
        _binding = MainFragmentBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        binding.btn1.setOnClickListener {
            val action : MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()

            action.setTitle(binding.Img1.contentDescription.toString())
            action.setImage(1)
            Navigation.findNavController(it).navigate(action)
        }
        binding.btn2.setOnClickListener {
            val action : MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()

            action.setTitle(binding.Img2.contentDescription.toString())
            action.setImage(2)
            Navigation.findNavController(it).navigate(action)
        }
        binding.btn3.setOnClickListener {
            val action : MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()

            action.setTitle(binding.Img3.contentDescription.toString())
            action.setImage(3)
            Navigation.findNavController(it).navigate(action)
        }
    }

}