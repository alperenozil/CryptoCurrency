package com.alperen.cryptocurrency.domain.usecase.getcoins

import com.alperen.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repo: CoinRepository
) {
    suspend operator fun invoke() = repo.getCoins()
}