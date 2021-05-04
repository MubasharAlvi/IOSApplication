package com.example.ioscameraandroidapp

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SplashScreenClass : Fragment(R.layout.splash_screen) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val handler = Handler().postDelayed(
            {
                SplastToCameraHom()
            }, 500

        )

    }

    private fun SplastToCameraHom() {
       val action = SplashScreenClassDirections.actionSplashScreenClassToCameraHomeScreenClass()
        findNavController().navigate(action)

    }

}

