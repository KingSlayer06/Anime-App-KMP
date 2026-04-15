package com.kingslayer06.anime_app.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.kingslayer06.anime_app.MainView
import kotlinx.serialization.Serializable

object HomeNavGraph: BaseNavGraph {
    sealed interface Destination {
        @Serializable
        data object Root: Destination

        @Serializable
        data object Home: Destination
    }

    override fun build(
        modifier: Modifier,
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation<Destination.Root>(startDestination = Destination.Home) {
            composable<Destination.Home> {
                MainView(
                    modifier = modifier,
                    onClick = { id ->
                        navController.navigate(
                        )
                    }
                )
            }
        }
    }
}