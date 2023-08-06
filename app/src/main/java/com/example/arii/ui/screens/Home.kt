package com.example.arii.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.arii.domain.models.Pokemon
import com.example.arii.ui.components.PokeItem

@Composable
fun Home(
    controller: NavHostController,
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by homeViewModel.uiState.collectAsState()
    val pokes = homeViewModel.getPokes().collectAsLazyPagingItems()
    Surface(modifier = modifier) {
        Base(pokes)
    }
}

@Composable
private fun Base(
    pokes: LazyPagingItems<Pokemon>,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(pokes.itemCount) { index ->
            pokes[index]?.let { poke ->
                PokeItem(poke = poke, modifier = modifier)
            }
        }
    }
}