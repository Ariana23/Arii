package com.example.arii.data.pokemon.di

import com.example.arii.data.pokemon.network.PokeHTTPClient
import com.example.arii.data.pokemon.network.PokeHTTPRepo
import com.example.arii.data.pokemon.repository.PokeDefaultRepository
import com.example.arii.data.pokemon.repository.PokeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface PokeDataModule {

    @Binds
    fun bindPokeRepository(pokeRepositoryImpl: PokeDefaultRepository): PokeRepository

    @Binds
    fun bindPokeClient(pokeHTTPClient: PokeHTTPClient): PokeHTTPRepo

}