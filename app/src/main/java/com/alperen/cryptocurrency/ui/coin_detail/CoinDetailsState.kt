package com.alperen.cryptocurrency.ui.coin_detail

import com.alperen.cryptocurrency.domain.model.CoinDetail

class CoinDetailsState(
    val isLoading: Boolean = false,
    val details: CoinDetail? = null,
    val error: String? = null
)