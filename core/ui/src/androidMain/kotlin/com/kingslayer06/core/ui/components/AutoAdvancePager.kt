package com.kingslayer06.core.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kingslayer06.core.ui.TextPrimary

@Composable
fun <T> AutoAdvancePager(
    pageItems: List<T>,
    modifier: Modifier = Modifier,
    pageContent: @Composable (PagerScope.(Int) -> Unit)
) {
    if (pageItems.isEmpty()) return

    val pagerState = rememberPagerState(pageCount = { pageItems.size })
    val pagerIsDragged by pagerState.interactionSource.collectIsDraggedAsState()

    val pageInteractionSource = remember { MutableInteractionSource() }
    val pageIsPressed by pageInteractionSource.collectIsPressedAsState()

    val autoAdvance = !pagerIsDragged && !pageIsPressed

    if (autoAdvance) {
        LaunchedEffect(pagerState, pageItems.size) {
            while (true) {
                delay(3000)
                val nextPage = (pagerState.currentPage + 1) % pageItems.size
                pagerState.animateScrollToPage(
                    page = nextPage,
                    animationSpec = tween(
                        durationMillis = 800,
                        easing = FastOutSlowInEasing
                    )
                )
            }
        }
    }

    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        HorizontalPager(
            state = pagerState
        ) { page ->
            pageContent(page)
        }

        PageIndicator(pagerState = pagerState)
    }
}

@Composable
fun PageIndicator(
    pagerState: PagerState,
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, bottom = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val isSelected = pagerState.currentPage == iteration
            val color = if (isSelected) TextPrimary else TextPrimary.copy(alpha = 0.5f)

            val width = if (isSelected) 20.dp else 10.dp
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(color)
                    .height(10.dp)
                    .width(width)
            )
        }
    }
}

@Preview
@Composable
fun PreviewAutoAdvancePager() {
    val colours = listOf(
        Color.Red,
        Color.Green,
        Color.Blue,
        Color.Yellow,
        Color.Magenta
    )

    AutoAdvancePager(
        pageItems = listOf(1, 2, 3, 4, 5),
    ) { page ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .background(color = colours[page])
        )
    }
}