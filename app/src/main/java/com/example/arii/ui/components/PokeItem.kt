package com.example.arii.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.arii.domain.models.Pokemon

@Composable
fun PokeItem(poke: Pokemon, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Text(text = poke.name)
            Text(text = poke.url)
        }
    }
}