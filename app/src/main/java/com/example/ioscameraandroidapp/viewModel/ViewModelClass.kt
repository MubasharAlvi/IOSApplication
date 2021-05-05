package com.example.ioscameraandroidapp.viewModel

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ioscameraandroidapp.R

class ViewModelClass : ViewModel() {
    private var  beautyImage =MutableLiveData(R.drawable.beauty_icon)
    val beautyImages : LiveData<Int> = beautyImage

    fun saveBeautyImage(newimage : Int){
        beautyImage.value=newimage
    }


}