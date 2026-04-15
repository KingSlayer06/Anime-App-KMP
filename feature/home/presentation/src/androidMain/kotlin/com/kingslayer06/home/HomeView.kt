package com.kingslayer06.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kingslayer06.home.components.AnimeListSections
import com.kingslayer06.home.components.AnimeRecommendations
import com.kingslayer06.home.domain.model.Anime
import com.kingslayer06.home.presentation.HomeUiState
import com.kingslayer06.home.presentation.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel(),
    onClick: (Int) -> Unit
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()

    Box(modifier = modifier) {
        when {
            uiState.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            else -> {
                HomeViewContent(
                    uiState = uiState,
                    onClick = onClick
                )
            }
        }
    }
}

@Composable
private fun HomeViewContent(
    uiState: HomeUiState,
    onClick: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            AnimeRecommendations(
                animeList = uiState.recommendations,
                onClick = onClick
            )
        }

        item {
            AnimeListSections(
                title = "Top Anime",
                animeList = uiState.topAnime,
                onClick = onClick,
                onSeeAll = {}
            )
        }

        item {
            AnimeListSections(
                title = "This Season",
                animeList = uiState.thisSeason,
                onClick = onClick,
                onSeeAll = {}
            )
        }

        item {
            AnimeListSections(
                title = "Coming Soon",
                animeList = uiState.upcomingSeason,
                onClick = {},
                onSeeAll = {}
            )
        }
    }
}

@Preview
@Composable
private fun HomeViewPreview() {
    HomeViewContent(
        uiState = HomeUiState(
            recommendations = emptyList(),
            topAnime = emptyList(),
            thisSeason = Anime.dummyList,
            upcomingSeason = Anime.dummyList
        ),
        onClick = {}
    )
}