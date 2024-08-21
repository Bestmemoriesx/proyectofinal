package com.example.proyecto_recetario.view.Home.Productos

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.proyecto_recetario.retrofit.Producto

@Composable
fun ProductoDetails(
    navController: NavController,
    productoId: Int,
    productoViewModel: ProductoViewModel
) {
    var cantidad by rememberSaveable { mutableStateOf(0) }
    val compras = productoViewModel.compras.value

    val producto = productoViewModel.productos.value.find { it.productoId == productoId }
        ?: Producto(
            productoId = productoId,
            nombre = "Producto A",
            descripcion = "Descripción del producto A",
            precio = 10.99,
            stock = 100,
            imagenUrl = "https://i.ibb.co/wWSGjg6/sdrtara.png"
        )

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Atrás")
        }

        Image(
            painter = rememberImagePainter(producto.imagenUrl),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = producto.nombre, fontSize = 24.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = producto.descripcion, fontSize = 16.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Precio: $${producto.precio}", fontSize = 18.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Cantidad: ", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedTextField(
                value = cantidad.toString(),
                onValueChange = { value ->
                    cantidad = value.toIntOrNull() ?: 0
                },
                modifier = Modifier.width(80.dp),
                singleLine = true
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val nuevaCompra = Compra(
                    producto = producto,
                    cantidad = cantidad
                )
                productoViewModel.agregarCompra(nuevaCompra)
            },
            enabled = cantidad > 0
        ) {
            Text("Comprar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (compras.isNotEmpty()) {
            Text("Resumen de Compra:", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Column {
                compras.forEach { compra ->
                    CompraItem(compra) { compraToRemove ->
                        productoViewModel.eliminarCompra(compraToRemove)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("shoopingCart") }
        ) {
            Text("Carrito de Pedidos")
        }
    }
}