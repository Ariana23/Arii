package com.example.arii.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.arii.data.pokemon.repository.PokeRepository
import com.example.arii.domain.models.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.annotation.concurrent.Immutable
import javax.inject.Inject

@Immutable
sealed interface HomeUIState {
    object Loading : HomeUIState
    data class Error(val message: String) : HomeUIState
}

enum class ListState {
    IDLE,
    LOADING,
    PAGINATING,
    ERROR,
    PAGINATION_EXHAUST,
}

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val pokeRepository: PokeRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUIState.Loading)
    val uiState = _uiState.asStateFlow()
    var listState by mutableStateOf(ListState.IDLE)

    private val pokes = pokeRepository.getPagedPokemon()

    fun getPokes(): Flow<PagingData<Pokemon>> = pokes.cachedIn(viewModelScope)

}