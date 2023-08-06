package com.example.arii.data

import com.example.arii.data.pokemon.network.PokemonResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// ESTA CLASE INSTANCIA RETROFIT Y ME DEVUELVE TODO LO QUE NECESITO PARA EL SERVICIO

// EL TIPO "SINGLETON" HACE QUE LO PUEDAR LLAMAR EN VARIAS PANTALAS SIN TENER QUE ESTAR INSTANCIANDOLO
//SINGLETON SIEMPRE ME VA A DEVOLVER LA MISMA INSTANCIA DE ESA CLASE, en vez de "class", lo cambio a "object"
object Api {

            // RETROFIR DIVIDE LA URL EN DOS:
            // url: https://pokeapi.co/api/v2/pokemon?limit=151
            // base_url = "https://pokeapi.co/api/v2/"
            // method = "pokemon?limit=151"

    // ESTE ES EL ENDPOINT DE LA UNI:
    // https://guarani3api.unlam.edu.ar/Vw_rest_datos_censales/


    private val builder: Retrofit.Builder = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())


    //DEFINIR LOS METODOS QUE VOY A UTILIZAR CON UNA INTERFACE

    interface RemoteService{
       // Se puede hacer de esta forma: @GET("pokemon?limit=151") o usando los parametros de retrofit en la query
        @GET("pokemon")
        fun loadPokemon(@Query("limit") limit:Int): PokemonResponse
    }

    //CREO UNA FUNCIONAR PARA DELVOLVER LA INFORMACION QUE TRAE RemoteService
    fun build() : RemoteService{
        return builder.build().create(RemoteService::class.java)
    }

}