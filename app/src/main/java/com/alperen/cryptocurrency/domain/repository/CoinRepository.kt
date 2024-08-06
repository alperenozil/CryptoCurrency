package com.alperen.cryptocurrency.domain.repository

import com.alperen.cryptocurrency.common.Resource
import com.alperen.cryptocurrency.data.remote.dto.coin_details_dto.CoinDetailsDto
import com.alperen.cryptocurrency.domain.model.Coin
import com.alperen.cryptocurrency.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    suspend fun getCoins(): Flow<Resource<List<Coin>>>

<<<<<<< Updated upstream
    suspend fun getCoinDetail(coinId: String): CoinDetailsDto

=======
    suspend fun getCoinDetail(coinId: String): Flow<Resource<CoinDetail>>
>>>>>>> Stashed changes
}