package com.example.proyecto_recetario.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyecto_recetario.view.Home.AboutView
import com.example.proyecto_recetario.view.Home.AccountView
import com.example.proyecto_recetario.viewModels.LoginViewM
import com.example.proyecto_recetario.view.Home.HomeView
import com.example.proyecto_recetario.view.Home.MyMenu
import com.example.proyecto_recetario.view.Home.Productos.ProductoDetails
import com.example.proyecto_recetario.view.Home.Windows.MyWeek
import com.example.proyecto_recetario.view.Home.Windows.PerfilUsuario
import com.example.proyecto_recetario.view.Home.Windows.TestTheMenu
import com.example.proyecto_recetario.view.login.TabsView
import com.example.proyecto_recetario.view.Home.Productos.ProductoViewModel
import com.example.proyecto_recetario.view.Home.Productos.ShoopingCart
import com.example.proyecto_recetario.view.Subscription.SubscriptionScreen

@Composable
fun NavManager(loginVM: LoginViewM) {

    val navController = rememberNavController()
    val productoViewModel: ProductoViewModel = viewModel()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            TabsView(navController, loginVM)
        }
        composable("home") {
            HomeView(navController)
        }
        composable("account") {
            PerfilUsuario(navController)
        }
        composable("about") {
            AboutView()
        }
        composable("mimenu") {
            MyMenu(navController)
        }
        composable("myWeek") {
            MyWeek(navController)
        }
        composable("perfilUsuario") {
            PerfilUsuario(navController)
        }
        composable("theMenu") {
            TestTheMenu(navController)
        }
        composable("subs") {
            SubscriptionScreen(navController)
        }
        composable("productoDetails/{productoId}") { backStackEntry ->
            val productoId = backStackEntry.arguments?.getString("productoId")?.toIntOrNull()
            if (productoId != null) {
                ProductoDetails(navController, productoId, productoViewModel)
            }
        }
        composable("shoopingCart") {
            ShoopingCart(navController, productoViewModel)
        }
    }
}