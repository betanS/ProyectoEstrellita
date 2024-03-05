package com.example.proyectoestrellita

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.proyectoestrellita.ui.theme.ProyectoEstrellitaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoEstrellitaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}
@Composable
fun App(
    navController: NavHostController = rememberNavController()
) {

    Scaffold() { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home"
        ) {
            composable(route = "home") {
                HomeScreen(navController)
            }
            composable(
                route = "second/{content}",
                arguments = listOf(
                    navArgument("content") {
                        type = NavType.StringType
                    }
                )
            ) {
                SecondScreen(
                    navController,
                    it.arguments?.getString("content")
                )
            }
            composable(
                route = "third/{content}/{content2}",
                arguments = listOf(
                    navArgument("content") {
                        type = NavType.StringType
                    }
                )
            ) {
                ThirdScreen(
                    navController,
                    it.arguments?.getString("content"),
                    it.arguments?.getString("content2")
                )
            }
        }
    }
}