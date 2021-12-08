package com.example.final_assignment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.final_assignment.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var adapter: RecyclerAdapter? = null
    private var toastDuration = Toast.LENGTH_SHORT

    companion object {
        fun newInstance() = MainFragment()
    }

    val viewModel : MainViewModel by viewModels()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listenerSetup()
//        observerSetup()
        recyclerSetup()
    }

    private fun listenerSetup(){
        binding.addButton.setOnClickListener {
            val name = binding.personName.text.toString()
            val phone = binding.personNumber.text.toString()

            if (name != "" && phone != ""){
                val person = Person(name,phone)
                viewModel.insertContact(person)
                clearFields()
            }else{
                Toast.makeText(context, "Please Enter a Name and a Phone Number",toastDuration).show()
            }
        }

        binding.findButton.setOnClickListener {
            val name = binding.personName.text.toString()

            if (name != ""){
                viewModel.findContact(binding.personName.text.toString())
                clearFields()
            }else{
                Toast.makeText(context, "Please Enter a Name",toastDuration).show()
            }
        }

        binding.ascButton.setOnClickListener{
            viewModel.ascendingOrder()
        }

        binding.descButton.setOnClickListener {
            viewModel.descendingOrder()
        }


    }

    private fun observerSetup(){
        viewModel.getAllContacts()?.observe(this, Observer { contacts -> contacts?.let {
            adapter?.setContactList(it)
        } })

        viewModel.getSearchResults().observe(this, Observer { contacts -> contacts?.let {
            if (it.isNotEmpty()){
                binding.personName.setText(it[0].personName)
                binding.personNumber.setText(it[0].personNumber)
            } else {
                Toast.makeText(context, "No Match Found", toastDuration).show()
            }
        } })
    }

    private fun recyclerSetup(){
        adapter = RecyclerAdapter(R.layout.card_layout)
        binding.contactRecycler.layoutManager = LinearLayoutManager(context)
        binding.contactRecycler.adapter = adapter
    }



    private fun clearFields(){
        binding.personName.setText("")
        binding.personNumber.setText("")
    }

}