package com.kingslayer06.details.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DetailsView(
    modifier: Modifier,
    id: Int,
    viewModel: DetailsViewModel = koinViewModel()
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(id) {
        viewModel.getAnimeById(id)
    }

    when {
        uiState.isLoading -> {

        }

        else -> {
            DetailsViewContent(
                modifier = modifier,
                uiState = uiState
            )
        }
    }
}

@Composable
private fun DetailsViewContent(
    modifier: Modifier = Modifier,
    uiState: DetailsUiState
) {

}