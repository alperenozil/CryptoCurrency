package com.alperen.cryptocurrency.ui.coin_list

import com.alperen.cryptocurrency.domain.model.Coin

class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin>? = emptyList(),
    val error: String? = ""
)