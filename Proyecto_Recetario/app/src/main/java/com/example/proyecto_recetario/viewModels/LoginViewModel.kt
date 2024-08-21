package com.example.proyecto_recetario.viewModels

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyecto_recetario.ui.theme.Crema600

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginViewModel(){
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Bienvenido") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Crema600)
            )
        }
    ) {

        ContentLoginViewModel()
    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ContentLoginViewModel(){
    Column (modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
    {


    }
}