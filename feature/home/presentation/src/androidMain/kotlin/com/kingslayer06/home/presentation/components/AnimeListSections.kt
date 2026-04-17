package com.kingslayer06.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kingslayer06.core.ui.Background
import com.kingslayer06.core.ui.Primary
import com.kingslayer06.core.ui.Secondary
import com.kingslayer06.core.ui.TextPrimary
import com.kingslayer06.core.ui.components.shimmerEffect
import com.kingslayer06.core.ui.interFontFamily
import com.kingslayer06.home.domain.model.Anime

@Composable
fun AnimeListSections(
    title: String,
    animeList: List<Anime>,
    onClick: (Int) -> Unit,
    onSeeAll: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                color = TextPrimary,
                fontFamily = interFontFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "see all",
                color = Secondary,
                fontFamily = interFontFamily,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .clickable { onSeeAll() }
            )
        }

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (animeList.isEmpty()) {
                items(
                    count = 10
                ) {
                    AnimeCardSkeleton()
                }
            } else {
                itemsIndexed(
                    items = animeList.take(10)
                ) { index, anime ->
                    AnimeCard(
                        anime = anime,
                        onClick = onClick
                    )
                }
            }
        }
    }
}

@Composable
private fun AnimeCard(
    anime: Anime,
    onClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .width(150.dp)
            .clickable { onClick(anime.uuid) },
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Background)
        ) {
            AsyncImage(
                model = anime.image,
                contentDescription = anime.title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillWidth
            )
        }

        Text(
            text = anime.title,
            color = TextPrimary,
            fontFamily = interFontFamily,
            fontSize = 15.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favourites",
                tint = Primary,
                modifier = Modifier.size(15.dp)
            )

            Text(
                text = anime.favourites,
                color = Primary,
                fontFamily = interFontFamily,
                fontSize = 15.sp
            )
        }
    }
}

@Composable
private fun AnimeCardSkeleton() {
    Column(
        modifier = Modifier.width(150.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(150.dp, 200.dp)
                .clip(RoundedCornerShape(16.dp))
                .shimmerEffect()
        )

        Box(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(15.dp)
                .clip(RoundedCornerShape(4.dp))
                .shimmerEffect()
        )

        Box(
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .height(15.dp)
                .clip(RoundedCornerShape(4.dp))
                .shimmerEffect()
        )
    }
}