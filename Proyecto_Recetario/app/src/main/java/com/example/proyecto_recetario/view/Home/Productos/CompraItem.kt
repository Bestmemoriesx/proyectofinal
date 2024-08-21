package com.example.proyecto_recetario.view.Home.Productos

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto_recetario.retrofit.Producto

@Composable
fun CompraItem(compra: Compra, onRemove: (Compra) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text("${compra.producto.nombre} x${compra.cantidad}", fontSize = 18.sp)
        Spacer(modifier = Modifier.weight(1f))
        Text("$${compra.producto.precio * compra.cantidad}", fontSize = 18.sp)
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = { onRemove(compra) }) {
            Text("Eliminar")
        }
    }
}
