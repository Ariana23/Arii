package com.example.arii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.arii.data.Api
import com.example.arii.data.PokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }
    //CREO LA FUNCION QUE ME VA A TRAER LOS DATOS Y LOS VA A MOSTRAR
    private fun init(){

        //VOY A MAPEAR LA CAJA DE TEXTO EN DONDE VA A MOSTRAR MI DATO, MAPEO EL ID DEL BOTON
        val tvResult : TextView = findViewById(R.id.tvResult)

        //ACA ESTOY USANDO LA FUNCION QUE ESTA ADENTRO DE LA API, LA QUE GUARDA LA LISTA DE USUARIOS(loadPokemon)
        val request = Api.build().loadPokemon(151)


        //si "object" me marca error, implemento lo que me dice
        request.enqueue(object : Callback<PokemonResponse>{

//SI SE CONECTO ENTRA EN EL PRIMERO METODO, SI NO SE CONECTO ENTRA EN EL SEGUNDO
            override fun onResponse(
                call: Call<PokemonResponse>, response: Response<PokemonResponse>) {

            //DEVUELVO LA RESPUESTA CON .body -- pokemonResponde es la clase en donde hice el mapeo de datos
                val pokemonResponse = response.body()

    //VALIDAMOS LOS DATOS PARA QUE NO SEAN NULOS, EL .let HACE ESA VALIDACION, en kotlen se hace de esta forma para evitar el if(variable == null)

                pokemonResponse?.results?.let { pokemons ->
                    //AHORA VOY A ITERAR LA LISTA DE USUARIOS

                    pokemons.forEach {
                        tvResult.append("${it.name}")

                        //ESTO ES UN SALTO DE LINEA
                        tvResult.append("\n")
                    }
                }

            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                println(t.message)
            }
        })
    }
}