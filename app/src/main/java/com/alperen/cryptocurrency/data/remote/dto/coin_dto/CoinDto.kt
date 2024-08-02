package com.alperen.cryptocurrency.data.remote.dto.coin_dto

import com.alperen.cryptocurrency.domain.model.Coin

data class CoinDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDto.toModel(): Coin = Coin(id, is_active, name, rank, symbol)
