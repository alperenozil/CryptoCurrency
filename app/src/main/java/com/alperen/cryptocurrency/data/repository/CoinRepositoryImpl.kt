package com.alperen.cryptocurrency.data.repository

import com.alperen.cryptocurrency.data.remote.CoinPaprikaApi
import com.alperen.cryptocurrency.data.remote.dto.coin_details_dto.CoinDetailsDto
import com.alperen.cryptocurrency.data.remote.dto.coin_dto.CoinDto
import com.alperen.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> = api.getCoins()

    override suspend fun getCoinDetail(coinId: String): CoinDetailsDto =
        api.getCoinDetails(coinId = coinId)

}

class CoinRepositoryMockImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> = api.getCoins()

    override suspend fun getCoinDetail(coinId: String): CoinDetailsDto =
        api.getCoinDetails(coinId = coinId)

}