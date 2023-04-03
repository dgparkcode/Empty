package com.dgparkcode.androidcodetesting

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NumberScannerScreen(
    onNavigateBackToNumbers: () -> Unit = {},
) {
    Column(modifier = Modifier) {
        Text(text = "NumberScanner")
        Button(onClick = onNavigateBackToNumbers) {
            Text(text = "Navigate back to Numbers")
        }
    }
}