package com.kingslayer06.anime_app.navigation

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.kingslayer06.core.ui.Background
import com.kingslayer06.core.ui.Surface
import com.kingslayer06.home.HomeView
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
                HomeView(
                    modifier = modifier
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(Surface, Background)
                            )
                        )
                )
            }
        }
    }

}