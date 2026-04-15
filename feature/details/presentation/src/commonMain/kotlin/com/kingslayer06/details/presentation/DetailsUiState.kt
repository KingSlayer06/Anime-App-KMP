package com.kingslayer06.details.presentation

import com.kingslayer06.details.domain.model.Anime

data class DetailsUiState(
    val isLoading: Boolean = false,
    val anime: Anime? = null,
    val errorMessage: String? = null,
)