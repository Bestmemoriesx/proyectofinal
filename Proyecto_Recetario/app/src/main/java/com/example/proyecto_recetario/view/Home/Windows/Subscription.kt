package com.example.proyecto_recetario.view.Subscription

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SubscriptionScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Tipos de Suscripciones",
            style = MaterialTheme.typography.headlineLarge,
            color = Color(0xFFCE1616),
            modifier = Modifier.padding(vertical = 16.dp)
        )

        SubscriptionCard(
            title = "Suscripción Básica",
            description = "Límite de pedidos: 10 por mes\nPrecio: $300.00\nMonto máximo por día: $25.00"
        )

        Spacer(modifier = Modifier.height(16.dp))

        SubscriptionCard(
            title = "Suscripción Estándar",
            description = "Límite de pedidos: 20 por mes\nPrecio: $${calculateMonthlySubscriptionPrice(15, 15.0)}\nMonto máximo por día: $100.00"
        )

        Spacer(modifier = Modifier.height(16.dp))

        SubscriptionCard(
            title = "Suscripción Premium",
            description = "Límite de pedidos: 30\nPrecio: $599.00\nMonto máximo por día: $29.00"
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { /* Acción para 'Mi Suscripción' */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA27722)), // Color crema
            shape = RoundedCornerShape(0.dp) // Forma rectangular sin esquinas redondeadas
        ) {
            Text(text = "Mi Suscripción")
        }
    }
}

@Composable
fun SubscriptionCard(title: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = androidx.compose.material3.CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* Acción para 'Adquirir' */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFAF8633)), // Color crema
                shape = RoundedCornerShape(0.dp) // Forma rectangular sin esquinas redondeadas
            ) {
                Text(text = "Adquirir")
            }
        }
    }
}

fun calculateMonthlySubscriptionPrice(limitePedidos: Int, costoPorPedido: Double): String {
    val precioMensual = limitePedidos * costoPorPedido
    return "%.2f".format(precioMensual) // Formatea el precio mensual a dos decimales
}
