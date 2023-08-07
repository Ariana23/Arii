package com.example.arii.data.pokemon.network

import com.example.arii.domain.models.Pokemon

interface PokeHTTPRepo {
    suspend fun listPagedPoke(limit: Int, offset: Int): List<Pokemon>
}