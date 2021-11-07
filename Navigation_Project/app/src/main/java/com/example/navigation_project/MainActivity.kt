package com.example.navigation_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri

class MainActivity : AppCompatActivity(),
    secondFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onFragmentInteraction(uri: Uri) {
    }

}