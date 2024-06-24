package com.claudiocastillo.apipractica.view

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.claudiocastillo.apipractica.R
import com.claudiocastillo.apipractica.viewmodel.DogViewModel

class DogActivity :  AppCompatActivity() {
    private lateinit var dogViewModel: DogViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog)

        dogViewModel = ViewModelProvider(this).get(DogViewModel::class.java)

        val imageView: ImageView = findViewById(R.id.dogImageView)
        val button: Button = findViewById(R.id.fetchButton)

        dogViewModel.dogImage.observe(this, Observer { imageUrl ->
            Glide.with(this).load(imageUrl).into(imageView)
        })

        button.setOnClickListener{
            dogViewModel.fetchRandomDogImage()
        }

    }
}