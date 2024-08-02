package com.alperen.cryptocurrency.ui

sealed class Screens(val route: String) {
    object CoinListScreen: Screens("coin_list_screen")
    object CoinDetailScreen: Screens("coin_detail_screen")
}