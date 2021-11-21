package com.example.intentproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.intentproject.databinding.ActivityMainBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), RecyclerAdapter.OnItemClickListener {
    private val request_code = 5
    private lateinit var binding: ActivityMainBinding

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    private var viewModel = MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        layoutManager = LinearLayoutManager(this)
        binding.contentMain.recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter(viewModel.imageList, this)
        binding.contentMain.recyclerView.adapter = adapter
    }

    override fun onItemClick(position: Int) {
        val i = Intent(this, MainActivity2::class.java)
        val selectedImage = viewModel.imageList[position]

        i.putExtra("title",selectedImage.titles)
        i.putExtra("details",selectedImage.details)
        i.putExtra("image",selectedImage.images)

        startActivityForResult(i,request_code)
    }


}