package com.example.proyecto_recetario.view.Home.Windows

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto_recetario.R
import com.example.proyecto_recetario.ui.theme.Crema800
import com.google.firebase.annotations.concurrent.Background

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilUsuario(navController: NavController) {
    var isEditing by remember { mutableStateOf(false) }
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Perfil de Usuario") },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Crema800) // color de arriba
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
                    .background(Color(0xFFdb9d60)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                        .padding(3.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.perfil), // Reemplaza con tu imagen de perfil de usuario
                        contentDescription = "Imagen de Perfil",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Armando") },
                    singleLine = true,
                    enabled = isEditing,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
                TextField(
                    value = apellido,
                    onValueChange = { apellido = it },
                    label = { Text("Suarez") },
                    singleLine = true,
                    enabled = isEditing,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
                TextField(
                    value = telefono,
                    onValueChange = { telefono = it },
                    label = { Text("990200857") },
                    singleLine = true,
                    enabled = isEditing,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
                TextField(
                    value = correo,
                    onValueChange = { correo = it },
                    label = { Text("artemise250@gmail.com") },
                    singleLine = true,
                    enabled = isEditing,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { isEditing = !isEditing },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(text = if (isEditing) "Guardar datos" else "Editar datos de perfil")
                }
                if (isEditing) {
                    Button(
                        onClick = { /* Implementar la lógica para guardar los datos */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Text(text = "Guardar datos")
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { navController.navigate("cambiarContrasena") }, // Navegar a la pantalla de cambio de contraseña
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(text = "Cambiar contraseña")
                }
            }
        }
    )
}
