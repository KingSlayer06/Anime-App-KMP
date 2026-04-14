package com.kingslayer06.anime_app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.kingslayer06.anime_app.navigation.BaseNavGraph
import com.kingslayer06.anime_app.navigation.HomeNavGraph

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = HomeNavGraph.Destination.Root
            ) {
                listOf<BaseNavGraph>(
                    HomeNavGraph
                ).forEach {
                    it.build(
                        modifier = Modifier.fillMaxSize(),
                        navController = navController,
                        navGraphBuilder = this
                    )
                }
            }
        }
    }
}