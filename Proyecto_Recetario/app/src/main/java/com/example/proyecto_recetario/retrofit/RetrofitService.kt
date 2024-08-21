package com.example.proyecto_recetario.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Producto(
    val productoId: Int,
    val nombre: String,
    val descripcion: String,
    val precio: Double,
    val stock: Int,
    val imagenUrl: String
)

interface ApiService {
    @GET("api/v1/Producto")
    suspend fun getProductos(): List<Producto>
}

object RetrofitInstance {
    private const val BASE_URL = "http://192.168.56.1:8080/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}