package com.alperen.cryptocurrency.domain.repository

import com.alperen.cryptocurrency.common.Resource
import com.alperen.cryptocurrency.data.remote.dto.coin_details_dto.CoinDetailsDto
import com.alperen.cryptocurrency.data.remote.dto.coin_dto.CoinDto
import com.alperen.cryptocurrency.domain.model.Coin
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    suspend fun getCoins(): Flow<Resource<List<Coin>>>

    suspend fun getCoinDetail(coinId: String): CoinDetailsDto

}