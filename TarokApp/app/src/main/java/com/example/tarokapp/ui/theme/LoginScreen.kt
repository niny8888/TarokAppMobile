package com.example.tarokapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoginScreen(
    onLoginSuccess: (String) -> Unit, // Function parameter to pass the token back
    onBack: () -> Unit,              // Function to handle "Back" button
    loginViewModel: LoginViewModel = viewModel() // ViewModel instance
) {
    // Observe the login state
    val loginState by loginViewModel.loginState.collectAsState()

    // Input states for username and password
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFF4F4F9),
                    shape = MaterialTheme.shapes.medium
                )
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                ),
                color = Color(0xFF333333)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Username input field
            Column(modifier = Modifier.fillMaxWidth()) {
                Text("Username", fontWeight = FontWeight.Bold, color = Color(0xFF333333))
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Enter username") },
                    singleLine = true
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            // Password input field
            Column(modifier = Modifier.fillMaxWidth()) {
                Text("Password", fontWeight = FontWeight.Bold, color = Color(0xFF333333))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Enter password") },
                    visualTransformation = PasswordVisualTransformation(),
                    singleLine = true
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Login button
            Button(
                onClick = { loginViewModel.login(username, password) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF4757))
            ) {
                Text("Login", color = Color.White, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(15.dp))

            // State-driven UI updates
            when (loginState) {
                is LoginState.Idle -> {}
                is LoginState.Loading -> Text("Logging in...", color = Color.Gray)
                is LoginState.Success -> {
                    val token = (loginState as LoginState.Success).token
                    LaunchedEffect(token) {
                        onLoginSuccess(token)
                    }
                }
                is LoginState.Error -> Text(
                    text = (loginState as LoginState.Error).error,
                    color = Color(0xFF94001B),
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Don't have an account? Register here",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color(0xFFFF4757)),
                modifier = Modifier.clickable { /* Navigate to register screen */ }
            )
        }

        // Back button
        Button(
            onClick = onBack,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5A5A5A))
        ) {
            Text("Back", color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}
