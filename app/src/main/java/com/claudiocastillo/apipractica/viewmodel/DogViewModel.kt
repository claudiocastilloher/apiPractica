package com.claudiocastillo.apipractica.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.claudiocastillo.apipractica.model.RetrofitInstance
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {
    private val _dogImage = MutableLiveData<String>()
    val dogImage: LiveData<String> get() = _dogImage

    fun fetchRandomDogImage(){
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getRandomDogImage()
                if (response.status =="success"){
                    _dogImage.value = response.imageUrl
                }
            } catch (e:Exception){
                //manejo de errores
            }
        }
    }
}