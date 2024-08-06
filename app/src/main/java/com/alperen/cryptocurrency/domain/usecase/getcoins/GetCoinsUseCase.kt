package com.alperen.cryptocurrency.domain.usecase.getcoins

import com.alperen.cryptocurrency.common.Resource
import com.alperen.cryptocurrency.data.remote.dto.coin_dto.toModel
import com.alperen.cryptocurrency.domain.model.Coin
import com.alperen.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repo: CoinRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val result = repo.getCoins().map { it.toModel() }
            emit(Resource.Success(result))
        } catch (e: HttpException) { // if response code doesnt start with 2
            emit(Resource.Error(e.localizedMessage ?: "unexpected error"))
        } catch (e: IOException) { // no internet connection
            emit(Resource.Error(e.localizedMessage ?: "network error"))
        }
    }
}