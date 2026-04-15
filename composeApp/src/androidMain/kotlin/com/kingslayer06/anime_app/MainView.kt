package com.kingslayer06.anime_app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.kingslayer06.core.ui.components.BottomNavigationBar
import com.kingslayer06.home.presentation.HomeView

@Composable
fun MainView(
    modifier: Modifier,
    onClick: (Int) -> Unit
) {
    val selectedRoute = remember {
        mutableStateOf("Home")
    }

    val pagerState = rememberPagerState { 3 }

    LaunchedEffect(selectedRoute.value) {
        val targetPage = when (selectedRoute.value) {
            "Home" -> 0
            "Explore" -> 1
            "My Library" -> 2
            else -> 0
        }
        if (pagerState.currentPage != targetPage) {
            pagerState.scrollToPage(targetPage)
        }
    }

    Scaffold(
        modifier = modifier,
        bottomBar = {
            BottomNavigationBar(
                selectedRoute = selectedRoute.value,
                onSelected = { selectedRoute.value = it }
            )
        }
    ) { innerPadding ->
        VerticalPager(
            state = pagerState,
            userScrollEnabled = false,
            modifier = modifier
                .padding(innerPadding)
        ) { page ->
            when(page) {
                0 -> HomeView(
                    modifier = Modifier.fillMaxSize(),
                    onClick = onClick
                )
                1 -> Box(Modifier.fillMaxSize())
                2 -> Box(Modifier.fillMaxSize())
            }
        }
    }
}