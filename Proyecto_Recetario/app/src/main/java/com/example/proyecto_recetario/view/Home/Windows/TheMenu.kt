package com.example.proyecto_recetario.view.Home.Windows

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.proyecto_recetario.retrofit.Producto
import com.example.proyecto_recetario.retrofit.RetrofitInstance
import retrofit2.HttpException
import java.io.IOException

@Composable
fun TheMenu(navController: NavController) {
    var Producto by remember { mutableStateOf<List<Producto>>(emptyList()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        try {
            Producto = RetrofitInstance.api.getProductos()
        } catch (e: HttpException) {
            errorMessage = "Error de red"
        } catch (e: IOException) {
            errorMessage = "Error de conexión"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Producto.forEach { producto ->
            ProductoCard(Producto = producto, onClick = {
                navController.navigate("productoDetails/${producto.productoId}")
            })
        }
    }
}

@Composable
fun ProductoCard(Producto: Producto, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberImagePainter(Producto.imagenUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .background(Color.Gray, shape = RoundedCornerShape(8.dp))
                    .padding(4.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = Producto.nombre, fontSize = 18.sp, color = Color.Black)
                Text(text = Producto.descripcion, fontSize = 14.sp, color = Color.Gray)
            }
        }
    }
}
