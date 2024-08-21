package com.example.proyecto_recetario.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ItemsMenu (
    val icon:ImageVector,
    val title:String,
    val ruta:String
){

    data object item_1:ItemsMenu(
        Icons.Default.Home,
        "Home",
        "Home"
    )
    data object item_2:ItemsMenu(
        Icons.Default.AccountCircle,
        "Mi Perfil",
        "Account"
    )
    data object item_3:ItemsMenu(
        Icons.Default.Place,
        "About",
        "About"
    )
}