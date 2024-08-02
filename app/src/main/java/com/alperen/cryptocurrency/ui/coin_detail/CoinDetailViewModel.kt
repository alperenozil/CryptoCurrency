package com.alperen.cryptocurrency.ui.coin_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alperen.cryptocurrency.common.Constants.PARAM_COIN_ID
import com.alperen.cryptocurrency.common.Resource
import com.alperen.cryptocurrency.domain.usecase.getcoindetails.GetCoinDetailsUseCase
import com.alperen.cryptocurrency.domain.usecase.getcoins.GetCoinsUseCase
import com.alperen.cryptocurrency.ui.coin_list.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinsDetailsUseCase: GetCoinDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _coinDetailsState = MutableStateFlow(value = CoinDetailsState())
    val coinDetailsState = _coinDetailsState.asStateFlow()

    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let { getCoinDetails(it) }
    }

    private fun getCoinDetails(coinId: String) {
        viewModelScope.launch {
            val coins = getCoinsDetailsUseCase.invoke(coinId)
            coins.collect {
                when (it) {
                    is Resource.Success -> _coinDetailsState.value = CoinDetailsState(details = it.data)
                    is Resource.Error -> _coinDetailsState.value = CoinDetailsState(error = it.message)
                    is Resource.Loading -> _coinDetailsState.value = CoinDetailsState(isLoading = true)
                }
            }
        }
    }
}