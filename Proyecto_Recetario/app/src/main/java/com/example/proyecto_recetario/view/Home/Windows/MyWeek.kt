package com.example.proyecto_recetario.view.Home.Windows

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyecto_recetario.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyWeek(navController: NavController) {
    var showImage by remember { mutableStateOf(false) }
    var selectedImageUrl by remember { mutableStateOf("") }
    var selectedDay by remember { mutableStateOf("") }

    // Lista de días de la semana y URLs de imágenes
    val daysOfWeek = listOf(
        "Lunes" to "https://i.ibb.co/5GSQck4/sandwiches-vista-superior-queso-crema-frutas.jpg",
        "Martes" to "https://i.ibb.co/FzNJKHh/Black-Friday-Wendy-s.jpg",
        "Miércoles" to "https://i.ibb.co/pdQj8bc/flat-lay-sandwiches-with-cream-cheese-fruits-with-copy-space.jpg",
        "Jueves" to "https://i.ibb.co/7NhkV77/flat-lay-sandwich-with-cucumbers-salmon-plate-with-spinach.jpg",
        "Viernes" to "https://example.com/viernes.jpg",
        "Sábado" to "https://example.com/sabado.jpg",
        "Domingo" to "https://example.com/domingo.jpg"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mi semana") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("myMenu") }) {
                        Icon(
                            painter = painterResource(id = R.drawable.flechaizquierda),
                            tint = Color.Unspecified,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Lista vertical de días de la semana con imágenes
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                items(daysOfWeek) { (day, imageUrl) ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp)
                            .clickable {
                                selectedDay = day
                                selectedImageUrl = imageUrl
                                showImage = true
                            }
                    ) {
                        Text(
                            text = day,
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 8.dp),
                            fontSize = 16.sp
                        )
                        Image(
                            painter = rememberImagePainter(imageUrl),
                            contentDescription = day,
                            modifier = Modifier
                                .size(150.dp)
                                .background(Color.Gray)
                        )
                    }
                }
            }

            // Mostrar la imagen en un recuadro si se selecciona un día
            if (showImage) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.5f))
                        .padding(32.dp), // Ajusta el padding para cambiar el tamaño del recuadro
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.9f) // Ajusta el ancho del recuadro (0.9f es 90% del ancho de la pantalla)
                            .height(400.dp) // Ajusta la altura del recuadro
                            .background(Color.Transparent)
                    ) {
                        Image(
                            painter = rememberImagePainter(selectedImageUrl),
                            contentDescription = selectedDay,
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Transparent)
                        )
                    }

                    // Botón para cerrar el recuadro
                    Button(
                        onClick = { showImage = false },
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(16.dp)
                    ) {
                        Text("Cerrar")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyWeek() {
    // Preview de la vista MyWeek
    MyWeek(navController = rememberNavController())
}
