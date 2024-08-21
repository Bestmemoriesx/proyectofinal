package com.example.proyecto_recetario.view.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.proyecto_recetario.viewModels.LoginViewM

import com.example.proyecto_recetario.ui.theme.Crema100

import com.example.proyecto_recetario.ui.theme.Crema800



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TabsView(navController: NavController,loginVM:LoginViewM) {
    Scaffold {

        var seleccionTab by remember { mutableStateOf(0) }
        val tabs = listOf("Iniciar Sesion", "Registrarse")

        Column {
            TabRow(selectedTabIndex = seleccionTab,
                contentColor = Crema800,
                containerColor = Crema100,
                indicator = { tabPosition ->
                    TabRowDefaults.Indicator(
                        Modifier.tabIndicatorOffset(tabPosition[seleccionTab])
                    )
                }
            )
            {
                tabs.forEachIndexed { index, title ->
                    Tab(selected = seleccionTab == index,
                        onClick = { seleccionTab = index },
                        text = { Text(text = title) })
                }
            }
            when (seleccionTab) {
                0 -> LoginView(navController,loginVM)
                1 -> RegistrarView(navController,loginVM)
            }
        }

    }
}