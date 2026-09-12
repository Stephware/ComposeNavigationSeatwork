package com.example.composenavigationseatwork.screens.home

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
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
    onViewDetails: (String, String, String, String) -> Unit
) {
    var studentId by remember {
        mutableStateOf("23-1727-857")
    }

    var name by remember {
        mutableStateOf("Stephen Kurl G. Pinacate")
    }

    var course by remember {
        mutableStateOf("BS Computer Engineering")
    }

    var yearLevel by remember {
        mutableStateOf("4-A")
    }

    var loginAttempts by remember {
        mutableStateOf(0)
    }

    var errorMessage by remember {
        mutableStateOf("")
    }

    var showDialog by remember {
        mutableStateOf(false)
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
            text = "Student ID",
            modifier = Modifier.align(Alignment.Start)
        )

        TextField(
            value = studentId,
            onValueChange = {
                studentId = it
                errorMessage = ""
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Name",
            modifier = Modifier.align(Alignment.Start)
        )

        TextField(
            value = name,
            onValueChange = {
                name = it
                errorMessage = ""
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Course",
            modifier = Modifier.align(Alignment.Start)
        )

        TextField(
            value = course,
            onValueChange = {
                course = it
                errorMessage = ""
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Year Level",
            modifier = Modifier.align(Alignment.Start)
        )

        TextField(
            value = yearLevel,
            onValueChange = {
                yearLevel = it
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(16.dp)
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
            modifier = Modifier.height(8.dp)
        )

        Button(
            onClick = {
                studentId = ""
                name = ""
                course = ""
                loginAttempts = 0
                errorMessage = ""
                yearLevel = ""
            }
        ) {
            Text(text = "Clear")
        }

        if (errorMessage.isNotEmpty()) {
            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = errorMessage
            )
        }

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Button(
            onClick = {
                errorMessage = when {
                    studentId.isBlank() -> "Student ID is required."
                    name.isBlank() -> "Name is required."
                    course.isBlank() -> "Course is required."
                    yearLevel.isBlank() -> "Year Level is required."
                    else -> ""
                }

                if (errorMessage.isEmpty()) {
                    showDialog = true
                }
            }
        ) {
            Text(text = "View Details")
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                showDialog = false
            },
            title = {
                Text(
                    text = "Confirm Student Information"
                )
            },
            text = {
                Text(
                    text = "View details for:\n$name?"
                )
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                    }
                ) {
                    Text(text = "Cancel")
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog = false

                        onViewDetails(
                            studentId.trim(),
                            name.trim(),
                            course.trim(),
                            yearLevel.trim()
                        )
                    }
                ) {
                    Text(text = "Continue")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        onViewDetails = { _, _, _, _ -> }
    )
}