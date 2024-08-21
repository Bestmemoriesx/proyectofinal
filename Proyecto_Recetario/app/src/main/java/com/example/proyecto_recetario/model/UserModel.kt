package com.example.proyecto_recetario.model

data class UserModel(
    val userId:String,
    val userNombre: String,
    val userApellido: String,
    val email: String,
    val telefono: String,

){
    fun toMap(): MutableMap<String, Any>{
        return mutableMapOf(
            "userId" to this.userId,
            "nombre" to this.userNombre,
            "apellido" to this.userApellido,
            "email" to this.email,
            "telefono" to this.telefono,

        )
    }
}
