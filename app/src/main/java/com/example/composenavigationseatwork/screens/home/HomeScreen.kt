package com.example.composenavigationseatwork.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Student Information",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Enter and review your student details",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                TextField(
                    value = studentId,
                    onValueChange = {
                        studentId = it
                        errorMessage = ""
                    },
                    label = {
                        Text(text = "Student ID")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                TextField(
                    value = name,
                    onValueChange = {
                        name = it
                        errorMessage = ""
                    },
                    label = {
                        Text(text = "Name")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                TextField(
                    value = course,
                    onValueChange = {
                        course = it
                        errorMessage = ""
                    },
                    label = {
                        Text(text = "Course")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                TextField(
                    value = yearLevel,
                    onValueChange = {
                        yearLevel = it
                    },
                    label = {
                        Text(text = "Year Level")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Text(
                    text = "Login Attempts",
                    style = MaterialTheme.typography.labelLarge
                )

                Text(
                    text = "$loginAttempts",
                    style = MaterialTheme.typography.headlineSmall
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                OutlinedButton(
                    onClick = {
                        loginAttempts++
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Add Attempt")
                }

                if (errorMessage.isNotEmpty()) {
                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = errorMessage,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Button(
                    onClick = {
                        errorMessage = when {
                            studentId.isBlank() -> "Student ID is required."
                            name.isBlank() -> "Name is required."
                            course.isBlank() -> "Course is required."
                            else -> ""
                        }

                        if (errorMessage.isEmpty()) {
                            showDialog = true
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "View Details")
                }

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                OutlinedButton(
                    onClick = {
                        studentId = ""
                        name = ""
                        course = ""
                        yearLevel = ""
                        loginAttempts = 0
                        errorMessage = ""
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Clear")
                }
            }
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