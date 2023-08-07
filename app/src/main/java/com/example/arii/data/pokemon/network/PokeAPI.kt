package com.example.arii.data.pokemon.network

import retrofit2.http.GET
import retrofit2.http.Query

interface PokeAPI {
    @GET("pokemon")
    suspend fun loadPokemon(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonResponse
}