package com.dgparkcode.androidcodetesting

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NumbersScreen(
    onNavigateToNumberScan: () -> Unit = {},
) {
    Column(modifier = Modifier) {
        Text(text = "Numbers")
        Button(onClick = onNavigateToNumberScan) {
            Text(text = "Navigate to NumberScan")
        }
    }
}