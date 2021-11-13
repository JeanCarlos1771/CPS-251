package com.example.recycleview

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    companion object{
        val imageList = generateList(9)

        fun generateList(size: Int): List<Data>{
            val list = ArrayList<Data>()

            fun rand(start: Int, end: Int): Int {
                require(start <= end) { "Illegal Argument" }
                return (start..end).random()
            }

            for(i in 0 until size){
                val randomNumber = rand(1,8)
                val drawable = when(randomNumber){
                    0 -> R.drawable.android_image_1
                    1 -> R.drawable.android_image_2
                    2 -> R.drawable.android_image_3
                    3 -> R.drawable.android_image_4
                    4 -> R.drawable.android_image_5
                    5 -> R.drawable.android_image_6
                    6 -> R.drawable.android_image_7
                    else -> R.drawable.android_image_8
                }
                val item = Data("Chapter ${randomNumber.toString()}","item ${randomNumber.toString()} details", drawable)
                list += item
            }
            return list
        }
    }
}