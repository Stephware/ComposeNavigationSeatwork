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
import androidx.compose.material3.OutlinedButton
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
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Student Details",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Review your student information",
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
                Text(
                    text = "Student ID",
                    style = MaterialTheme.typography.labelMedium
                )

                Text(
                    text = studentId,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(
                    modifier = Modifier.height(18.dp)
                )

                Text(
                    text = "Name",
                    style = MaterialTheme.typography.labelMedium
                )

                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(
                    modifier = Modifier.height(18.dp)
                )

                Text(
                    text = "Course",
                    style = MaterialTheme.typography.labelMedium
                )

                Text(
                    text = course,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(
                    modifier = Modifier.height(18.dp)
                )

                Text(
                    text = "Year Level",
                    style = MaterialTheme.typography.labelMedium
                )

                Text(
                    text = yearLevel,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = onEdit,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Edit Information")
        }

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
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