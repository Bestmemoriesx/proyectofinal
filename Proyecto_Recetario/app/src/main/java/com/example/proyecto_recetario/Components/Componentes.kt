package com.example.proyecto_recetario.Components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto_recetario.ui.theme.Crema700
import com.example.proyecto_recetario.ui.theme.Crema800

@Composable
fun space(size: Dp=20.dp){
    Spacer(modifier = Modifier.height(size))

}
@Composable
fun Texto(texto:String,Tamaño:TextUnit){
    Text(text =texto,
        fontWeight = FontWeight.ExtraLight,
        fontSize = Tamaño,
        color = Crema800
    )
}
@Composable
fun CajaTexto(
    value: String,
    onValueChange: (String)->Unit,
    label:String
){
    OutlinedTextField(value = value,
        onValueChange = onValueChange,
        label = {Text(text =(label), fontSize = 15.sp )},
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally))


}
