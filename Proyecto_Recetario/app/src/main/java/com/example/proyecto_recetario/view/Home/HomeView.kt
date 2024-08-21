    package com.example.proyecto_recetario.view.Home


    import androidx.compose.foundation.Image
    import androidx.compose.foundation.background
    import androidx.compose.foundation.clickable
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Box

    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.PaddingValues
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.Spacer

    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.size
    import androidx.compose.foundation.layout.width
    import androidx.compose.foundation.lazy.LazyRow
    import androidx.compose.foundation.lazy.rememberLazyListState
    import androidx.compose.foundation.shape.CircleShape
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.material3.AlertDialog
    import androidx.compose.material3.BottomAppBar
    import androidx.compose.material3.Button

    import androidx.compose.material3.DrawerState
    import androidx.compose.material3.DrawerValue
    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.Icon
    import androidx.compose.material3.IconButton
    import androidx.compose.material3.Scaffold
    import androidx.compose.material3.Text
    import androidx.compose.material3.TextButton
    import androidx.compose.material3.TextField
    import androidx.compose.material3.TextFieldDefaults
    import androidx.compose.material3.TopAppBar


    import androidx.compose.material3.rememberDrawerState
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.LaunchedEffect
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.rememberCoroutineScope

    import androidx.compose.runtime.setValue
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.draw.clip
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.platform.LocalContext
    import androidx.compose.ui.res.painterResource


    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp

    import androidx.navigation.NavController
    import coil.compose.rememberImagePainter
    import com.example.proyecto_recetario.Components.CajaTexto
    import com.example.proyecto_recetario.Components.HomeView.MenuLateral
    import com.example.proyecto_recetario.Components.HomeView.TopBar
    import com.example.proyecto_recetario.R
    import kotlinx.coroutines.delay
    import kotlinx.coroutines.launch

    @Composable
    fun ContentHomeView(drawerState: DrawerState, navController: NavController) {
        Scaffold(
            topBar = {
                TopBar(drawerState = drawerState, title = "Principal")
            }
        ) { pad ->
            NotificationsView(paddingValues = pad, navController = navController)
        }
    }
    @Composable
    fun NotificationsView(paddingValues: PaddingValues, navController: NavController) {
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            MyMenu(navController = navController)
        }
    }
    @Composable
    fun HomeView(navController: NavController) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        MenuLateral(navController, drawerState) {
            ContentHomeView(drawerState = drawerState, navController = navController)
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyMenu(navController: NavController) {
        // Lista de recursos de imágenes locales que se mostrarán
        val imageResources = listOf(
            R.drawable.cami,
            R.drawable.neta,
            R.drawable.cami,
            R.drawable.lalal
        )

        var currentIndex by remember { mutableStateOf(0) }
        val coroutineScope = rememberCoroutineScope()
        val listState = rememberLazyListState()
        var showLogoutDialog by remember { mutableStateOf(false) }

        // Cambiar automáticamente las imágenes cada 5 segundos
        LaunchedEffect(Unit) {
            while (true) {
                delay(5000)
                currentIndex = (currentIndex + 1) % imageResources.size
            }
        }

        // Ajustar la posición de desplazamiento del LazyRow
        LaunchedEffect(currentIndex) {
            coroutineScope.launch {
                listState.scrollToItem(currentIndex)
            }
        }

        // Mostrar el diálogo de cierre de sesión
        if (showLogoutDialog) {
            AlertDialog(
                onDismissRequest = { showLogoutDialog = false },
                title = { Text("Cerrar sesión") },
                text = { Text("¿Está seguro de que desea cerrar sesión?") },
                confirmButton = {
                    TextButton(onClick = {
                        showLogoutDialog = false
                        navController.navigate("TabsView") // Cambia a la ruta de TabsView
                    }) {
                        Text("Sí")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showLogoutDialog = false }) {
                        Text("No")
                    }
                }
            )
        }

        Scaffold(
            bottomBar = {
                BottomAppBar(
                    contentPadding = PaddingValues(0.dp) // para centrar los botones :)
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp), // Ajusta padding horizontal para centrar los botones
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconTextButton(iconRes = R.drawable.calendario, text = "Semana") {
                            navController.navigate("myWeek")
                        }
                        IconTextButton(iconRes = R.drawable.esdia, text = "Menús") {
                            navController.navigate("TheMenu")
                        }
                        IconTextButton(iconRes = R.drawable.perfil, text = "Suscripcion") {
                            navController.navigate("subs")
                        }
                    }
                }
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(Color(0xFFdb9d60)) // color de fondo
                    .padding(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(600.dp) // Altura del contenedor de la imagen
                        .background(Color.White, RoundedCornerShape(8.dp))
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        LazyRow(
                            state = listState,
                            modifier = Modifier
                                .height(550.dp) // Ajusta la altura de la imagen
                                .fillMaxWidth()
                            //  .width(50.dp) //Ajustar el ancho
                        ) {
                            items(imageResources.size) { index ->
                                Image(
                                    painter = painterResource(imageResources[index]),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillParentMaxHeight()
                                        .width(350.dp) // Aumenta el ancho de la imagen
                                        .padding(end = 16.dp) // Ajusta el espacio entre las imágenes
                                        .height(300.dp) // Ajusta la altura de la imagen
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            repeat(imageResources.size) { index ->
                                Box(
                                    modifier = Modifier
                                        .size(8.dp)
                                        .padding(4.dp)
                                        .clip(CircleShape)
                                        .background(if (index == currentIndex) Color.Black else Color.LightGray)
                                )
                            }
                        }
                    }
                }
            }
        }
    }


    @Composable
    fun IconTextButton(iconRes: Int, text: String, onClick: () -> Unit) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(4.dp) // Ajusta el padding para más espacio
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Gray)
                .padding(8.dp)
                .clickable(onClick = onClick) // Hacer que el botón sea clickeable
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(24.dp) // Ajusta el tamaño del ícono
            )
            Spacer(modifier = Modifier.height(4.dp)) // Espacio entre el ícono y el texto
            Text(
                text,
                fontSize = 12.sp, // Tamaño del texto ajustado para que sea más visible
                color = Color.Black
            )
        }
    }

