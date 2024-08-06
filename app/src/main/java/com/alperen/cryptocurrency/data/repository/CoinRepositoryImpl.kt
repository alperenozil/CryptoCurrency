package com.alperen.cryptocurrency.data.repository

import com.alperen.cryptocurrency.common.Resource
import com.alperen.cryptocurrency.data.remote.CoinPaprikaApi
import com.alperen.cryptocurrency.data.remote.dto.coin_details_dto.CoinDetailsDto
import com.alperen.cryptocurrency.data.remote.dto.coin_details_dto.toModel
import com.alperen.cryptocurrency.data.remote.dto.coin_dto.toModel
import com.alperen.cryptocurrency.domain.model.Coin
import com.alperen.cryptocurrency.domain.model.CoinDetail
import com.alperen.cryptocurrency.domain.repository.CoinRepository
<<<<<<< Updated upstream
=======
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
>>>>>>> Stashed changes
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

<<<<<<< Updated upstream
    override suspend fun getCoins(): List<CoinDto> = api.getCoins()
=======
    override suspend fun getCoins(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val result = api.getCoins().map { it.toModel() }
            emit(Resource.Success(result))
        } catch (e: HttpException) { // if response code doesnt start with 2
            emit(Resource.Error(e.localizedMessage ?: "unexpected error"))
        } catch (e: IOException) { // no internet connection
            emit(Resource.Error(e.localizedMessage ?: "network error"))
        }
    }

>>>>>>> Stashed changes

    override suspend fun getCoinDetail(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val result = api.getCoinDetails(coinId).toModel()
            emit(Resource.Success(result))
        } catch (e: HttpException) { // if response code doesnt start with 2
            emit(Resource.Error(e.localizedMessage ?: "unexpected error"))
        } catch (e: IOException) { // no internet connection
            emit(Resource.Error(e.localizedMessage ?: "network error"))
        }
    }
}

/*
class CoinRepositoryMockImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> = api.getCoins()

    override suspend fun getCoinDetail(coinId: String): CoinDetailsDto =
        api.getCoinDetails(coinId = coinId)

}*/
