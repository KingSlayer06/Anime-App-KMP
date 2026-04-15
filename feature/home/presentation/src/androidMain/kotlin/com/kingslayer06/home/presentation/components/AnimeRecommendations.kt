package com.kingslayer06.home.presentation.components

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kingslayer06.core.ui.Background
import com.kingslayer06.core.ui.TextPrimary
import com.kingslayer06.core.ui.components.AutoAdvancePager
import com.kingslayer06.core.ui.components.shimmerEffect
import com.kingslayer06.core.ui.interFontFamily
import com.kingslayer06.home.domain.model.Anime

@Composable
fun AnimeRecommendations(
    animeList: List<Anime>,
    onClick: (Int) -> Unit
) {
    if (animeList.isEmpty()) {
        AnimeCardSkeleton()
    } else {
        AutoAdvancePager(
            pageItems = animeList,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        ) { page ->
            AnimeCard(
                anime = animeList[page],
                onClick = onClick
            )
        }
    }
}

@Composable
private fun AnimeCard(
    anime: Anime,
    onClick: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .background(Background)
            .fillMaxWidth()
            .height(220.dp)
            .clickable { onClick(anime.uuid) }

    ) {
        AsyncImage(
            model = anime.image,
            contentDescription = anime.title,
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
                    text = anime.title,
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
                        text = anime.favourites,
                        color = TextPrimary,
                        fontFamily = interFontFamily,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun AnimeCardSkeleton() {
    Box(
        modifier = Modifier
            .background(Background)
            .fillMaxWidth()
            .height(220.dp)
            .shimmerEffect()

    )
}