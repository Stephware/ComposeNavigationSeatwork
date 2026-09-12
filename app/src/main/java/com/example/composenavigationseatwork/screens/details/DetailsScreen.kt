package com.example.composenavigationseatwork.screens.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DetailsScreen(
    studentId: String,
    name: String,
    course: String,
    yearLevel: String,
    onEdit: () -> Unit,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Student Details",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Student ID",
                    style = MaterialTheme.typography.bodySmall
                )

                Text(
                    text = studentId,
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                Text(
                    text = "Name",
                    style = MaterialTheme.typography.bodySmall
                )

                Text(
                    text = name,
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                Text(
                    text = "Course",
                    style = MaterialTheme.typography.bodySmall
                )

                Text(
                    text = course,
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                Text(
                    text = "Year Level",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = yearLevel,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = onEdit
        ) {
            Text(text = "Edit Information")
        }

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Button(
            onClick = onBack
        ) {
            Text(text = "Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    DetailsScreen(
        studentId = "23-1727-857",
        name = "Stephen Kurl G. Pinacate",
        course = "BS Computer Engineering",
        yearLevel = "4-A",
        onEdit = {},
        onBack = {}
    )
}