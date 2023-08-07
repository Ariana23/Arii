package com.example.arii.data.pokemon.repository

import androidx.paging.PagingData
import com.example.arii.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokeRepository {
    fun getPagedPokemon(): Flow<PagingData<Pokemon>>
}