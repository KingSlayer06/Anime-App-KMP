package com.kingslayer06.explore.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kingslayer06.core.network.util.onFailure
import com.kingslayer06.core.network.util.onSuccess
import com.kingslayer06.core.network.util.toErrorMessage
import com.kingslayer06.explore.domain.model.Anime
import com.kingslayer06.explore.domain.model.AnimeGenre
import com.kingslayer06.explore.domain.useCases.GetAnimeGenreUseCase
import com.kingslayer06.explore.domain.useCases.SearchAnimeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ExploreUiState(
    val isLoading: Boolean = false,
    val animeGenres: List<AnimeGenre> = emptyList(),
    val searchedAnime: List<Anime> = emptyList(),
    val errorMessage: String? = null
)

class ExploreViewModel(
    private val getAnimeGenreUseCase: GetAnimeGenreUseCase,
    private val searchAnimeUseCase: SearchAnimeUseCase
): ViewModel() {
    private val _state = MutableStateFlow(ExploreUiState())
    val state = _state.asStateFlow()

    init {
        getAnimeGenres()
    }

    fun getAnimeGenres() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            getAnimeGenreUseCase.execute()
                .onSuccess { genres ->
                    _state.update { it.copy(isLoading = false, animeGenres = genres) }
                }
                .onFailure { error ->
                    _state.update { it.copy(isLoading = false, errorMessage = error.toErrorMessage()) }
                }
        }
    }

    fun searchAnime(query: String) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            searchAnimeUseCase.execute(10, query)
                .onSuccess { animeList ->
                    _state.update { it.copy(isLoading = false, searchedAnime = animeList) }
                }
                .onFailure { error ->
                    _state.update { it.copy(isLoading = false, errorMessage = error.toErrorMessage()) }
                }
        }
    }
}