package com.kingslayer06.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kingslayer06.home.domain.model.Anime
import com.kingslayer06.home.domain.useCases.GetThisSeasonAnimeUseCase
import com.kingslayer06.home.domain.useCases.GetTopRatedAnimeUseCase
import com.kingslayer06.home.domain.useCases.GetUpcomingSeasonAnimeUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class HomeUiState(
    val isLoading: Boolean = false,
    val recommendations: List<Anime> = emptyList(),
    val topAnime: List<Anime> = emptyList(),
    val thisSeason: List<Anime> = emptyList(),
    val upcomingSeason: List<Anime> = emptyList(),
    val errorMessage: String? = null,
)

class HomeViewModel(
    private val getTopRatedAnimeUseCase: GetTopRatedAnimeUseCase,
    private val getThisSeasonAnimeUseCase: GetThisSeasonAnimeUseCase,
    private val getUpcomingSeasonAnimeUseCase: GetUpcomingSeasonAnimeUseCase
): ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        fetchAllData()
    }

    private fun fetchAllData() {
        viewModelScope.launch {
            getRecommendations()
            delay(500)
            getTopAnime()
            delay(500)
            getThisSeason()
            delay(500)
            getUpcomingSeason()
        }
    }

    fun getRecommendations(limit: Int = 5) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            getTopRatedAnimeUseCase.execute(limit, "bypopularity")
                .onSuccess { recommendations ->
                    _state.update { it.copy(isLoading = false, recommendations = recommendations) }
                }
                .onFailure { error ->
                    _state.update { it.copy(isLoading = false, errorMessage = error.message) }
                }
        }
    }

    fun getTopAnime(limit: Int = 10) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            getTopRatedAnimeUseCase.execute(limit, "favorite")
                .onSuccess { topAnime ->
                    _state.update { it.copy(isLoading = false, topAnime = topAnime) }
                }
                .onFailure { error ->
                    _state.update { it.copy(isLoading = false, errorMessage = error.message) }
                }
        }
    }

    fun getThisSeason(limit: Int = 10) {
        viewModelScope.launch {
            _state.update { HomeUiState(isLoading = true) }
            getThisSeasonAnimeUseCase.execute(limit)
                .onSuccess { thisSeason ->
                    _state.update { it.copy(isLoading = false, thisSeason = thisSeason) }
                }
                .onFailure { error ->
                    _state.update { it.copy(isLoading = false, errorMessage = error.message) }
                }
        }
    }

    fun getUpcomingSeason(limit: Int = 10) {
        viewModelScope.launch {
            _state.update { HomeUiState(isLoading = true) }
            getUpcomingSeasonAnimeUseCase.execute(limit)
                .onSuccess { upcomingSeason ->
                    _state.update { it.copy(isLoading = false, upcomingSeason = upcomingSeason) }
                }
                .onFailure { error ->
                    _state.update { it.copy(isLoading = false, errorMessage = error.message) }
                }
        }
    }
}