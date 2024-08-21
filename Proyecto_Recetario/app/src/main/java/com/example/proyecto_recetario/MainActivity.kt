package com.example.proyecto_recetario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.proyecto_recetario.viewModels.LoginViewM
import com.example.proyecto_recetario.Navigation.NavManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginVM :LoginViewM by viewModels()

        enableEdgeToEdge()
        setContent {
            NavManager(loginVM)


        }
    }
}






