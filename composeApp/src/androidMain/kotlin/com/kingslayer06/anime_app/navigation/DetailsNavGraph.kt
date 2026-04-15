package com.kingslayer06.anime_app.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.kingslayer06.details.presentation.DetailsView
import kotlinx.serialization.Serializable

object DetailsNavGraph: BaseNavGraph {
    sealed interface Destination {
        @Serializable
        data object Root : Destination

        @Serializable
        data class Details(val id: Int) : Destination
    }

    override fun build(
        modifier: Modifier,
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation<Destination.Root>(startDestination = Destination.Details::class) {
            composable<Destination.Details> {
                val id = it.toRoute<Destination.Details>().id
                DetailsView(
                    modifier = modifier,
                    id = id
                )
            }
        }
    }
}