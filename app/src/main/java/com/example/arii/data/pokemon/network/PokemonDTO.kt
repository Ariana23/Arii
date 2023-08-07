package com.example.arii.data.pokemon.network

import com.example.arii.domain.models.Pokemon

//ESTA CLASE SE CREA PARA MAPEAR LOS PARAMETROS DEL WS

data class PokemonResponse(
    val count:Int,
    val next:String,
    val previous:String,
    val results:List<Pokemon>
)
