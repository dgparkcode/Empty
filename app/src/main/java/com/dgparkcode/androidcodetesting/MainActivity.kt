package com.dgparkcode.androidcodetesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dgparkcode.androidcodetesting.ui.theme.AndroidCodeTestingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCodeTestingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val appNavController = rememberNavController()
                    NavHost(
                        navController = appNavController,
                        startDestination = "main",
                        route = "root"
                    ) {
                        composable(route = "main") {
                            MainScreen(
                                onNavigateToNumberScan = {
                                    appNavController.navigate("scan")
                                }
                            )
                        }
                        composable(route = "scan") {
                            NumberScannerScreen(
                                onNavigateBackToNumbers = {
                                    appNavController.navigate("main") {
                                        popUpTo(route = "scan"){
                                            inclusive = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidCodeTestingTheme {
        Greeting("Android")
    }
}