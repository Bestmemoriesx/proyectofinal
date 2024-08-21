package com.example.proyecto_recetario.view.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto_recetario.Components.Alert
import com.example.proyecto_recetario.Components.Texto
import com.example.proyecto_recetario.Components.space
import com.example.proyecto_recetario.viewModels.LoginViewM
import com.example.proyecto_recetario.R
import com.example.proyecto_recetario.ui.theme.Burgundy
import com.example.proyecto_recetario.ui.theme.Crema800
import com.example.proyecto_recetario.ui.theme.Crema900


@Composable
fun LoginView(navController: NavController, loginVM: LoginViewM){

    /*CAJA COMPLETA DE LOGEO*/
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

    Column (modifier = Modifier
        .fillMaxSize()
        .background(Crema900)
        .padding(60.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        /*VARIABLES DE LOGEO*/
        var usuario by remember {
            mutableStateOf("")
        }
        var contrasenia by remember {
            mutableStateOf("")
        }
        /*LOGO Y NOMBRE DE MARCA*/
        Image(painter = painterResource(id = R.drawable.adadad),
            contentDescription =""
            )

        Texto(texto = "Sabores Peruanos", Tamaño = 30.sp)
        space()



        /* CAJAS DE TEXTO*/
        OutlinedTextField(value = usuario,
            onValueChange ={usuario=it},

            label = { Text("Usuario", fontSize = 15.sp) },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
        OutlinedTextField(value = contrasenia,
            onValueChange ={contrasenia=it},
            label = { Text("contraseña", fontSize = 15.sp) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
        space()
        /*BOTON INGRESO Y RECUPERAR CLAVE*/
        Button(onClick = { loginVM.login(usuario,contrasenia){
            navController.navigate("home")} },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(Crema800)
             ) {
            Text(text = "Ingresar")

        }
        if (loginVM.showAlert) {
            Alert(title = "Alerta",
                message = "Usuario y/o Contrasena Incorrectos",
                confirmText = "Aceptar",
                onConfirmClick = { loginVM.closeAlert() }) {
            }
        }


    }
}}


