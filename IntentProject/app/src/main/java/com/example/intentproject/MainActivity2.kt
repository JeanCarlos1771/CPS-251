package com.example.intentproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentproject.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return

        val title = extras.getString("title")
        binding.title.text = title
        val details =  extras.getString("details")
        binding.details.text = details
        val image = extras.getInt("image")
        binding.imageView.setBackgroundResource(image)
    }
}