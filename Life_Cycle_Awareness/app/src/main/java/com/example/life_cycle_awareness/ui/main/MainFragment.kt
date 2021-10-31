package com.example.life_cycle_awareness.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import com.example.life_cycle_awareness.Demo_Observer
import com.example.life_cycle_awareness.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var demoObserver: Demo_Observer


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

        demoObserver = Demo_Observer()

        lifecycle.addObserver(Demo_Observer())
        // TODO: Use the ViewModel

        if(viewModel.lifeCycleStatus.isEmpty()){

        }else{
            binding.textView.text = viewModel.lifeCycleStatus
        }

        for(element in demoObserver.cycleStatus){
            viewModel.lifeCycleStatus += element+"\n"
            binding.textView.text = viewModel.lifeCycleStatus
        }
    }

}

