package com.alperen.cryptocurrency.ui.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alperen.cryptocurrency.common.Resource
import com.alperen.cryptocurrency.domain.model.Coin
import com.alperen.cryptocurrency.domain.usecase.getcoins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _coinListState = MutableStateFlow(value = CoinListState())
    val coinListState = _coinListState.asStateFlow()

    init {
        getCoins()
<<<<<<< Updated upstream
=======
        //getTodos()
>>>>>>> Stashed changes
    }

    private fun getCoins() {
        viewModelScope.launch {
            val coins = getCoinsUseCase.invoke()
            coins.collect {
                when (it) {
                    is Resource.Success -> {
                        _coinListState.value = CoinListState(coins = it.data)
                    }
                    is Resource.Error -> _coinListState.value = CoinListState(error = it.message)
                    is Resource.Loading -> _coinListState.value = CoinListState(isLoading = true)
                }
            }
        }
    }
}