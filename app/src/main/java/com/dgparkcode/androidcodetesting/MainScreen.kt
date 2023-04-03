package com.dgparkcode.androidcodetesting

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

data class BottomNavItem(val route: String)

@Composable
fun MainScreen(
    onNavigateToNumberScan: () -> Unit = {},
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                val items = listOf(
                    BottomNavItem("lotteries"),
                    BottomNavItem("numbers"),
                    BottomNavItem("info"),
                )
                items.forEach { item ->
                    NavigationBarItem(
                        selected = currentDestination
                            ?.hierarchy?.any { it.route == item.route }
                            ?: false,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(Icons.Default.Home, null) },
                        label = { Text(text = item.route) }
                    )
                }
            }
        }
    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = "lotteries"
        ) {
            composable("lotteries") {
                LotteriesScreen(
                    onNavigateToNumberScan = onNavigateToNumberScan
                )
            }
            composable("numbers") {
                NumbersScreen(
                    onNavigateToNumberScan = onNavigateToNumberScan
                )
            }
            composable("info") {
                InfoScreen()
            }
        }
    }
}