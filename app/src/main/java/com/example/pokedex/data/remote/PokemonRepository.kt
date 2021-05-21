package com.example.pokedex.data.remote

import com.example.pokedex.data.remote.responses.Pokemon
import com.example.pokedex.data.remote.responses.PokemonList
import com.example.pokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("Unknown error occured.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonDetail(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonDetail(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("Unknown error occured.")
        }
        return Resource.Success(response)
    }
}