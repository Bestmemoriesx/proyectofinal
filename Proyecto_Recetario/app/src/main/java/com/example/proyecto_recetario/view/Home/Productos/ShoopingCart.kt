package com.example.proyecto_recetario.view.Home.Productos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto_recetario.ui.theme.Crema900

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoopingCart(
    navController: NavController,
    productoViewModel: ProductoViewModel
) {
    val compras = productoViewModel.compras.value
    val totalCosto = compras.sumOf { it.producto.precio * it.cantidad }

    // Lista de ciudades de Lima
    val ciudadesLima = listOf(
        "Lima Centro", "Miraflores", "San Isidro", "Barranco", "Surco",
        "San Borja", "La Molina", "San Juan de Lurigancho", "San Juan de Miraflores", "Callao"
    )

    // Estado para manejar la ubicación de envío y la ciudad seleccionada
    var ubicacionEnvio by remember { mutableStateOf("") }
    var ciudadSeleccionada by remember { mutableStateOf("Selecciona una ciudad") }
    var ciudadesLimaExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Crema900)
            .padding(16.dp)

    ) {
        // Botón de volver con estilo similar al IconButton en ProductoDetails
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.Start)
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Carrito de Pedidos", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))

        // Campo para ingresar la ubicación de envío
        TextField(
            value = ubicacionEnvio,
            onValueChange = { ubicacionEnvio = it },
            label = { Text("Ubicación de Envío") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Menú desplegable para seleccionar la ciudad de Lima
        ExposedDropdownMenuBox(
            expanded = ciudadesLimaExpanded,
            onExpandedChange = { ciudadesLimaExpanded = !ciudadesLimaExpanded }
        ) {
            TextField(
                readOnly = true,
                value = ciudadSeleccionada,
                onValueChange = {},
                label = { Text("Ciudad") },
                trailingIcon = {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Seleccionar Ciudad")
                },
                modifier = Modifier.fillMaxWidth().menuAnchor() // Asegúrate de que menuAnchor esté disponible
            )
            DropdownMenu(
                expanded = ciudadesLimaExpanded,
                onDismissRequest = { ciudadesLimaExpanded = false }
            ) {
                ciudadesLima.forEach { ciudad ->
                    DropdownMenuItem(
                        text = { Text(ciudad) },
                        onClick = {
                            ciudadSeleccionada = ciudad
                            ciudadesLimaExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(compras) { compra ->
                CompraItem(compra) { compraToRemove ->
                    productoViewModel.eliminarCompra(compraToRemove)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("Total items in cart: ${compras.size}", fontSize = 18.sp)
        Text("Costo Total: $${totalCosto}", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Aquí puedes agregar la lógica para proceder con la compra
                navController.popBackStack()
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFAF8633)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Proceder con la compra")
        }
    }
}
