package com.example.proyecto_recetario.view.Home.Productos


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyecto_recetario.retrofit.Producto
import com.example.proyecto_recetario.retrofit.RetrofitInstance
import kotlinx.coroutines.launch

class ProductoViewModel : ViewModel() {
    private val _productos = mutableStateOf<List<Producto>>(emptyList())
    val productos: State<List<Producto>> get() = _productos

    private val _compras = mutableStateOf<List<Compra>>(emptyList())
    val compras: State<List<Compra>> get() = _compras

    val totalCosto: State<Double> get() = mutableStateOf(
        _compras.value.sumOf { it.producto.precio * it.cantidad }
    )

    init {
        cargarProductos()
    }

    private fun cargarProductos() {
        viewModelScope.launch {
            try {
                val productos = RetrofitInstance.api.getProductos()
                _productos.value = productos
            } catch (e: Exception) {
                println("Error: ${e.message}")
            }
        }
    }

    fun agregarCompra(compra: Compra) {
        _compras.value = _compras.value + compra
    }

    fun eliminarCompra(compra: Compra) {
        _compras.value = _compras.value - compra
    }
}

data class Compra(val producto: Producto, val cantidad: Int)
