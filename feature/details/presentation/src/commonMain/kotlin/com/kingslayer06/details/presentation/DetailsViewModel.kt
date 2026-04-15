package com.kingslayer06.details.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kingslayer06.core.network.util.onFailure
import com.kingslayer06.core.network.util.onSuccess
import com.kingslayer06.core.network.util.toErrorMessage
import com.kingslayer06.details.domain.useCases.GetAnimeByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val getAnimeByIdUseCase: GetAnimeByIdUseCase,
): ViewModel() {
    private val _state = MutableStateFlow(DetailsUiState())
    val state = _state.asStateFlow()

    fun getAnimeById(id: Int) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            getAnimeByIdUseCase.execute(id)
                .onSuccess { anime ->
                    _state.update { it.copy(isLoading = false, anime = anime) }
                }
                .onFailure { error ->
                    _state.update { it.copy(isLoading = false, errorMessage = error.toErrorMessage()) }
                }
        }
    }
}