package com.kingslayer06.explore.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ExploreView(
    modifier: Modifier = Modifier,
    viewModel: ExploreViewModel = koinViewModel(),
    onClick: (Int) -> Unit
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()

    Box(modifier = modifier) {
        ExploreViewContent(
            uiState = uiState,
            onClick = onClick,
            onSearch = { query ->
                viewModel.searchAnime(query)
            }
        )
    }
}

@Composable
private fun ExploreViewContent(
    uiState: ExploreUiState,
    onClick: (Int) -> Unit,
    onSearch: (String) -> Unit
) {

}