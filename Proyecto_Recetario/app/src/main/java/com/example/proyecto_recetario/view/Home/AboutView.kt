package com.example.proyecto_recetario.view.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.rememberNavController
import com.example.proyecto_recetario.R

@Composable
fun AboutView() {
    Scaffold(

        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(52.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(onClick = { }) {

                }
                Image(
                    painter = painterResource(id = R.drawable.logochef),
                    contentDescription = "Sobre Nosotros",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(bottom = 5.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Sobre MANJAR",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "MANJAR es una innovadora plataforma de suscripción que simplifica la adquisición de menús para trabajadores de oficina y público en general. Ofrecemos una solución conveniente para la selección y compra de menús variados y de alta calidad, con el objetivo de ahorrar tiempo y costos en la preparación de comidas diarias.",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center
                )
            }
        }
    )
}