package com.alperen.cryptocurrency.ui.coin_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.alperen.cryptocurrency.common.Resource
import com.alperen.cryptocurrency.domain.model.ToDo
import com.alperen.cryptocurrency.domain.usecase.GetTodosUseCase
import com.alperen.cryptocurrency.domain.usecase.getcoins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
    private val getTodosUseCase: GetTodosUseCase
) : ViewModel() {

    val todosPager = Pager(PagingConfig(pageSize = 15)) {
        getTodosUseCase
    }.flow.cachedIn(viewModelScope)


    private val _coinListState = MutableStateFlow(value = CoinListState())
    val coinListState = _coinListState.asStateFlow()

    private val _todoListState: MutableStateFlow<PagingData<ToDo>> = MutableStateFlow(PagingData.empty())
    val toDoListState = _todoListState.asStateFlow()

    init {
        //getCoins()
        //getTodos()
        /*viewModelScope.launch {
            Pager(
                config = PagingConfig(
                    30
                )
            ) {
                getTodosUseCase
            }.flow.cachedIn(viewModelScope).collect {
                _todoListState.value = it
            }
        }*/
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

    /*private fun getTodos() {
        viewModelScope.launch {
            val todos = getTodosUseCase.invoke()
            todos.collect {
                when (it) {
                    is Resource.Success -> {
                        _todoListState.value = ToDoListState(todos = it.data)
                    }

                    is Resource.Error -> _todoListState.value = ToDoListState(error = it.message)
                    is Resource.Loading -> _todoListState.value = ToDoListState(isLoading = true)
                }
            }
        }
    }*/
}