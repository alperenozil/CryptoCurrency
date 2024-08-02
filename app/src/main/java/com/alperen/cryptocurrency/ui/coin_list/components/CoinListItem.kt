package com.alperen.cryptocurrency.ui.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alperen.cryptocurrency.domain.model.Coin

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick: () -> Unit
) {
    Column(
        Modifier
            .fillMaxWidth()
            .clickable { onItemClick() }
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(coin.name)
        Text("${coin.isActive}")
    }
}