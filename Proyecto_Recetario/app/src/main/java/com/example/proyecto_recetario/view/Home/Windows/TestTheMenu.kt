package com.example.proyecto_recetario.view.Home.Windows

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyecto_recetario.view.Home.Productos.ProductoViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TestTheMenu(navController: NavController, viewModel: ProductoViewModel = viewModel()) {
    val productos by viewModel.productos
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(productos) { producto ->
            ProductoCard(Producto = producto, onClick = {
                navController.navigate("productoDetails/${producto.productoId}")
            })
        }
    }
}