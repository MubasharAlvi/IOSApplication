package com.example.ioscameraandroidapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.ioscameraandroidapp.databinding.BeautyModeBinding
import com.example.ioscameraandroidapp.viewModel.ViewModelClass
import kotlinx.android.synthetic.main.beauty_mode.*

class BeautyModeClass : Fragment(){
    private val viewModelClass : ViewModelClass by activityViewModels()
    lateinit var binding: BeautyModeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModelClass.beautyImages.observe(viewLifecycleOwner,{beautyImage ->
            binding.beautymodepreviewid.setBackgroundResource(beautyImage)
        })
        binding  =
            DataBindingUtil.inflate(layoutInflater, R.layout.beauty_mode, container, false)
        return inflater.inflate(R.layout.beauty_mode, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}