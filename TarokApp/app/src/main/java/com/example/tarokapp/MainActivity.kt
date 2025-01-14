package com.example.tarokapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tarokapp.ui.theme.TarokAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarokAppTheme {
                var currentScreen by remember { mutableStateOf("home") }
                var token by remember { mutableStateOf<String?>(null) }

                when (currentScreen) {
                    "home" -> HomeScreen(
                        navigateToLogin = { currentScreen = "login" },
                        navigateToGames = { currentScreen = "games" }
                    )
                    "login" -> LoginScreen(
                        onLoginSuccess = { authToken ->
                            token = authToken // Set the token on successful login
                            currentScreen = "account"
                        },
                        onBack = { currentScreen = "home" }
                    )
                    "games" -> GamesScreen(
                        onBack = { currentScreen = "home" }
                    )
                    "account" -> AccountScreen(
                        token = token ?: "", // Display the token or a fallback value
                        onLogout = {
                            token = null
                            currentScreen = "home"
                        }
                    )
                }
            }
        }
    }
}