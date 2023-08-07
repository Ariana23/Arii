package com.example.arii.data.pokemon.network

import com.example.arii.domain.models.Pokemon
import javax.inject.Inject

class PokeHTTPClient @Inject constructor(private val http: PokeAPI) : PokeHTTPRepo {
    override suspend fun listPagedPoke(limit: Int, offset: Int): List<Pokemon> {
        return http.loadPokemon(limit, offset).results
    }
}