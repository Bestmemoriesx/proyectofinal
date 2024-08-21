package com.example.proyecto_recetario.view.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto_recetario.Components.Alert
import com.example.proyecto_recetario.Components.CajaTexto
import com.example.proyecto_recetario.Components.Texto
import com.example.proyecto_recetario.Components.space
import com.example.proyecto_recetario.ui.theme.Crema800
import com.example.proyecto_recetario.ui.theme.Proyecto_RecetarioTheme
import com.example.proyecto_recetario.viewModels.LoginViewM



@Composable
fun RegistrarView(navController: NavController, loginVM: LoginViewM){
    Proyecto_RecetarioTheme {
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Column(modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

                /*VARIABLES DE REGISTRO*/
                 ) {
                var RegistrarNombre by remember {
                mutableStateOf("")
                }
                var RegistrarApellido by remember {
                mutableStateOf("")
                }
                var RegistrarCorreo by remember {
                    mutableStateOf("")
                }
                var RegistrarTelefono by remember {
                    mutableStateOf("")
                }
                var RegistrarContrasenia by remember {
                    mutableStateOf("")
                }
                /* FORMULARIO DE REGISTRO*/

                Texto(texto = "Estas a un paso....", Tamaño = 30.sp)
                space()
                OutlinedTextField(value = RegistrarNombre,
                    onValueChange = {RegistrarNombre=it},
                label = {Text(text ="Nombre" )})

                CajaTexto(value = RegistrarApellido,
                    onValueChange ={RegistrarApellido=it} ,
                    label = "Apellido")
                CajaTexto(value = RegistrarTelefono,
                    onValueChange = {RegistrarTelefono=it},
                    label = "Telefono")
                CajaTexto(value = RegistrarCorreo,
                    onValueChange ={RegistrarCorreo=it} ,
                    label ="Correo" )

                OutlinedTextField(value = RegistrarContrasenia,
                    onValueChange ={RegistrarContrasenia=it},
                    label = { Text("Contraseña") },
                    visualTransformation = PasswordVisualTransformation()
                    )

                space()
                Button(
                    onClick = { loginVM.createUser(
                        RegistrarNombre,RegistrarApellido,RegistrarTelefono,RegistrarCorreo,RegistrarContrasenia){
                        navController.navigate("Home")
                    } },
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(),
                    colors = ButtonDefaults.buttonColors(Crema800)

                ) {
                    Text(text = "Registrar")

                }

                if (loginVM.showAlert) {
                    Alert(title = "Alerta",
                        message = "Usuario no creado",
                        confirmText = "Aceptar",
                        onConfirmClick = { loginVM.closeAlert() }) {
                    }
                }




        }

    }

}
}