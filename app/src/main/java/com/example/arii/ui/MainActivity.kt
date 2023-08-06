package com.example.arii.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ar.com.depietro.tuiter.ui.theme.PokeTheme
import com.example.arii.ui.screens.Home
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainScreen() {
        // Controller permite la navegación entre pantallas.
        // Remember navController es un factory de un controller. Traerá siempre el
        // mismo como si fuese un singleton.
        val controller = rememberNavController()
        // A surface container using the 'background' color from the theme
        PokeTheme {
            Scaffold { contentPadding ->
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(contentPadding),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // NavHost define cuáles son las "rutas" a las que se puede acceder
                    // dentro de la aplicación de Android.
                    NavHost(
                        navController = controller,
                        startDestination = "home"
                    ) {
                        composable("home") {
                            Home(controller)
                        }
                    }
                }
            }
        }
    }
}