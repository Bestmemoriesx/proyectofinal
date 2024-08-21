package com.example.proyecto_recetario.view.MyMenu

import android.annotation.SuppressLint
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.proyecto_recetario.Components.HomeView.TopBar


@Composable
fun SeleccionView(navController: NavController){



}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ContentSelecioonView(drawerState: DrawerState){
    Scaffold (
        topBar = {
            TopBar(drawerState = drawerState, title = "Elige tu menu")
        }
    ){
        Text(text = "hola")

    }
}

