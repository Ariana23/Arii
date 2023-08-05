package com.example.arii.data

//ESTA CLASE SE CREA PARA MAPEAR LOS PARAMETROS DEL WS

data class PokemonResponse(
    val count:Int,
    val next:String,
    val previous:String,
    val results:List<Pokemon>
)

data class Pokemon(val name:String, val url:String)
