package com.example.arii.data.pokemon.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.arii.data.pokemon.network.PokeHTTPRepo
import com.example.arii.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokeDefaultRepository @Inject constructor(
    private val pokeHTTPRepo: PokeHTTPRepo
) : PokeRepository {
    override fun getPagedPokemon(): Flow<PagingData<Pokemon>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { PagingPokeSource(pokeHTTPRepo) }
        ).flow
    }
}