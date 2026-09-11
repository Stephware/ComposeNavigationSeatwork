package com.example.composenavigationseatwork.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onViewDetails: () -> Unit
) {
    var loginAttempts by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Student Information",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = "Name: Stephen Kurl G. Pinacate",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Course: BS Computer Engineering",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Year: 4",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Login Attempts: $loginAttempts",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Button(
            onClick = {
                loginAttempts++
            }
        ) {
            Text(text = "Add Attempt")
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = onViewDetails
        ) {
            Text(text = "View Details")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        onViewDetails = {}
    )
}