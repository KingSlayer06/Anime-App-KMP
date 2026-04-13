package com.kingslayer06.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kingslayer06.home.domain.model.Anime
import com.kingslayer06.home.domain.useCases.GetTopAnimeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class HomeUiState(
    val isLoading: Boolean = false,
    val topAnime: List<Anime> = emptyList(),
    val errorMessage: String? = null,
)

class HomeViewModel(
    private val getTopAnimeUseCase: GetTopAnimeUseCase
): ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getTopAnime()
    }

    fun getTopAnime() {
        viewModelScope.launch {
            _state.update { HomeUiState(isLoading = true) }
            getTopAnimeUseCase.execute()
                .onSuccess { topAnime ->
                    _state.update { HomeUiState(topAnime = topAnime) }
                }
                .onFailure { error ->
                    _state.update { HomeUiState(errorMessage = error.message) }
                }
        }
    }
}