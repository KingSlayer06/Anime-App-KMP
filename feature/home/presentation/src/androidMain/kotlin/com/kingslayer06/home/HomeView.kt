package com.kingslayer06.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
    viewModel: HomeViewModel = koinViewModel()
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()

    when {
        uiState.isLoading -> {
            Box(
                modifier = modifier,
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        else -> {
            HomeViewContent(
                modifier = modifier,
                uiState = uiState
            )
        }
    }
}

@Composable
private fun HomeViewContent(
    modifier: Modifier = Modifier,
    uiState: HomeUiState
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            AnimeRecommendations(
                animeList = uiState.recommendations,
                onClick = {}
            )
        }

        item {
            AnimeListSections(
                title = "Top Anime",
                animeList = uiState.topAnime,
                onClick = {},
                onSeeAll = {}
            )
        }

        item {
            AnimeListSections(
                title = "This Season",
                animeList = uiState.thisSeason,
                onClick = {},
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
        )
    )
}