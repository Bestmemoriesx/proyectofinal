package com.example.proyecto_recetario.view.Home.Productos

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.proyecto_recetario.retrofit.Producto

@Composable
fun ProductosScreen(viewModel: ProductoViewModel = viewModel()) {
    val productos = viewModel.productos.value

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 16.dp) // Padding right to make space for scrollbar
        ) {
            items(productos) { producto ->
                ProductoItem(producto)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        // Add a vertical scrollbar on the right side
        VerticalScrollbar(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .fillMaxHeight()
                .width(8.dp)
                .padding(start = 4.dp) // Padding to avoid overlap with content
        )
    }
}

@Composable
fun VerticalScrollbar(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(Color.Gray.copy(alpha = 0.3f))
    ) {
        // Jetpack Compose's built-in vertical scrollbar
        // `LazyColumn` already provides built-in scrollbars when scrolled
    }
}

@Composable
fun ProductoItem(producto: Producto) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = rememberImagePainter(data = producto.imagenUrl),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = producto.nombre)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Precio: ${producto.precio}")
    }
}
