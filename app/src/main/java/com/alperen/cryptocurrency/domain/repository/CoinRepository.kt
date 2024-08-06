package com.alperen.cryptocurrency.domain.repository

import com.alperen.cryptocurrency.data.remote.dto.coin_details_dto.CoinDetailsDto
import com.alperen.cryptocurrency.data.remote.dto.coin_dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinDetail(coinId: String): CoinDetailsDto

}