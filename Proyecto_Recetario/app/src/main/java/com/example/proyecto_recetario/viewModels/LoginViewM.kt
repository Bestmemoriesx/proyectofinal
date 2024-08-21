package com.example.proyecto_recetario.viewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyecto_recetario.model.UserModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewM:ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    var showAlert by mutableStateOf(false)

    fun login(email: String, password: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            onSuccess()
                        } else {
                            Log.d("Error en firebase", "usuario o contraseña incorrectos")
                            showAlert = true
                        }
                    }
            } catch (e: Exception) {
                Log.d("Error en jetpack", "ERROR:${e.localizedMessage}")
            }
        }
    }
    fun createUser(userNombre: String,userApellido: String,telefono: String,email: String, password: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            try {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            saveUser(userNombre,userApellido,telefono)
                            onSuccess()
                        } else {
                            Log.d("ERROR EN FIREBASE", "Error al crear usuario")
                            showAlert = true
                        }
                    }
            } catch (e: java.lang.Exception) {
                Log.d("ERROR EN JETPACK", "ERROR: ${e.localizedMessage}")
            }
        }
    }
    private fun saveUser(userNombre:String,userApellido:String,telefono:String){
        val id = auth.currentUser?.uid
        val email = auth.currentUser?.email

        viewModelScope.launch(Dispatchers.IO){
            val user = UserModel(
                userId = id.toString(),
                userNombre = userNombre ,
                userApellido= userApellido,
                email = email.toString(),
                telefono=telefono,


            )

            FirebaseFirestore.getInstance().collection("Users")
                .add(user)
                .addOnSuccessListener {
                    Log.d("GUARDO", "Guardo correctamente")
                }.addOnFailureListener{
                    Log.d("ERROR AL GUARDAR", "ERROR al guardar en firestore")
                }
        }


    }



    fun closeAlert(){
        showAlert = false
    }
}