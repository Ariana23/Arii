package com.example.arii.data.pokemon.di

import com.example.arii.data.pokemon.network.PokeAPI
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PokeDataProvider {

    /**
     * Provides the [PokeAPI] implementation.
     */
    @Provides
    @Singleton
    fun providePokeAPI(gson: Gson): PokeAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://pokeapi.co/api/v2/")
            .build()
            .create(PokeAPI::class.java)
    }
}