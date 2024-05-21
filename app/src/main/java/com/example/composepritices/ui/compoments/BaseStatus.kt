package com.example.composepritices.ui.compoments

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun baseStatus() {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "There is no item",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.primary
            )
        )
    }
}