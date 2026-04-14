package com.kingslayer06.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.kingslayer06.core.ui.Background
import com.kingslayer06.core.ui.Primary
import com.kingslayer06.core.ui.Surface
import com.kingslayer06.core.ui.TextPrimary
import com.kingslayer06.core.ui.components.AutoAdvancePager
import com.kingslayer06.core.ui.interFontFamily
import com.kingslayer06.home.components.AnimeListSections
import com.kingslayer06.home.domain.model.Anime
import com.kingslayer06.home.presentation.HomeUiState
import com.kingslayer06.home.presentation.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel
import kotlin.math.absoluteValue
import kotlin.math.max

@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel()
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()

    when {
        uiState.isLoading -> {
            CircularProgressIndicator()
        }
        uiState.errorMessage != null -> {
            Text(text = uiState.errorMessage ?: "Something went wrong")
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
        modifier = modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Surface, Background)
                )
            ),
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
                modifier = modifier,
                title = "Top Anime",
                animeList = uiState.topAnime,
                onClick = {},
                onSeeAll = {}
            )
        }

        item {
            AnimeListSections(
                modifier = modifier,
                title = "This Season",
                animeList = uiState.thisSeason,
                onClick = {},
                onSeeAll = {}
            )
        }

        item {
            AnimeListSections(
                modifier = modifier,
                title = "Coming Soon",
                animeList = uiState.upcomingSeason,
                onClick = {},
                onSeeAll = {}
            )
        }
    }
}

@Composable
private fun AnimeRecommendations(
    animeList: List<Anime>,
    onClick: (String) -> Unit
) {
    val pagerState = rememberPagerState(pageCount = { animeList.size })

    AutoAdvancePager(
        pageItems = animeList,
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
    ) { page ->
        Box(
            modifier = Modifier
                .background(Background)
                .fillMaxWidth()
                .height(220.dp)
                .clickable { onClick(animeList[page].uuid) }

        ) {
            AsyncImage(
                model = animeList[page].image,
                contentDescription = animeList[page].title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillWidth
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Background.copy(0.5f))
                        )
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp, bottom = 32.dp),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = animeList[page].title,
                        color = TextPrimary,
                        fontFamily = interFontFamily,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Favourites",
                            tint = TextPrimary,
                            modifier = Modifier.size(20.dp)
                        )

                        Text(
                            text = animeList[page].favourites,
                            color = TextPrimary,
                            fontFamily = interFontFamily,
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeViewPreview() {
    HomeViewContent(
        uiState = HomeUiState(
            recommendations = Anime.dummyList,
            topAnime = Anime.dummyList,
            thisSeason = Anime.dummyList,
            upcomingSeason = Anime.dummyList
        )
    )
}