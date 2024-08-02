package com.alperen.cryptocurrency.ui.coin_detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alperen.cryptocurrency.ui.Screens
import com.alperen.cryptocurrency.ui.coin_detail.CoinDetailViewModel
import com.alperen.cryptocurrency.ui.coin_list.CoinListViewModel
import com.alperen.cryptocurrency.ui.coin_list.components.CoinListItem

@Composable
fun CoinDetailsScreen(
    coinListViewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state = coinListViewModel.coinDetailsState.collectAsState()
    Box(Modifier.fillMaxSize()) {
        state.value.details?.let{
            Text(text = it.name)
            Text(text = it.description)
        }
    }
}
