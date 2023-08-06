package com.example.arii.data.pokemon.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.arii.data.pokemon.network.PokeHTTPRepo
import com.example.arii.domain.models.Pokemon

const val NETWORK_PAGE_SIZE = 20
private const val INITIAL_LOAD_SIZE = 1

/**
 * Esta clase tiene como función gestionar el paginado de los datos que se obtienen desde la API.
 */
class PagingPokeSource(
    private val pokeRepository: PokeHTTPRepo
) : PagingSource<Int, Pokemon>() {

    /**
     * Este método será llamado cuando se necesiten obtener nuevos pokemones.
     */
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        val position = params.key ?: INITIAL_LOAD_SIZE
        val offset =
            if (params.key != null) ((position - 1) * NETWORK_PAGE_SIZE) + 1 else INITIAL_LOAD_SIZE
        return try {
            val page = params.key ?: 1
            val response = pokeRepository.listPagedPoke(page, params.loadSize)
            val nextKey = if (response.isEmpty()) {
                null
            } else {
                page + NETWORK_PAGE_SIZE
            }
            LoadResult.Page(
                data = response,
                prevKey = if (page == 1) null else page.minus(NETWORK_PAGE_SIZE),
                nextKey = nextKey
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    /**
     * Esta función se utiliza para identificar si el paginado se encuentra cerca de alguno de los
     * límites de la lista. Ya sea el primero o el último.
     */
    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}