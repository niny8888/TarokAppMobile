package com.example.tarokapp.ui.theme

import com.example.tarokapp.LoginState
import com.example.tarokapp.LoginViewModel

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
fun RegisterScreen(
    onRegisterSuccess: (String) -> Unit,
    onBack: () -> Unit
) {
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
                text = "Register",
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

            // Register button
            Button(
                onClick = { onRegisterSuccess("sample-token") },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF4757))
            ) {
                Text("Register", color = Color.White, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(15.dp))

            // Back button
            Button(
                onClick = onBack,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5A5A5A))
            ) {
                Text("Back", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}
