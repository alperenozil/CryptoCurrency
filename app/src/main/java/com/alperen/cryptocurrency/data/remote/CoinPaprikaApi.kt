package com.alperen.cryptocurrency.data.remote

import com.alperen.cryptocurrency.data.remote.dto.coin_details_dto.CoinDetailsDto
import com.alperen.cryptocurrency.data.remote.dto.coin_dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    @GET(value = "/v1/coins")
    suspend fun getCoins() : List<CoinDto>

    @GET(value = "/v1/coins/{coinId}")
    suspend fun getCoinDetails(@Path("coinId") coinId: String) : CoinDetailsDto
}