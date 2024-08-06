package com.alperen.cryptocurrency.domain.usecase.getcoindetails

import com.alperen.cryptocurrency.common.Resource
import com.alperen.cryptocurrency.data.remote.dto.coin_details_dto.toModel
import com.alperen.cryptocurrency.data.remote.dto.coin_dto.toModel
import com.alperen.cryptocurrency.domain.model.Coin
import com.alperen.cryptocurrency.domain.model.CoinDetail
import com.alperen.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailsUseCase @Inject constructor(
    private val repo: CoinRepository
) {
    suspend operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = repo.getCoinDetail(coinId)
}