package com.alperen.cryptocurrency.ui.coin_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.alperen.cryptocurrency.ui.Screens
import com.alperen.cryptocurrency.ui.coin_list.CoinListViewModel

@Composable
fun CoinListScreen(
    navController: NavController,
    coinListViewModel: CoinListViewModel = hiltViewModel()
) {
    val state = coinListViewModel.coinListState.collectAsState()
    val stateTodo = coinListViewModel.toDoListState.collectAsLazyPagingItems()
    val todopager = coinListViewModel.todosPager.collectAsLazyPagingItems()
    /*if(state.value.isLoading) Text("coin list loading...")
    Column(Modifier.fillMaxSize()) {
        LazyColumn(Modifier.fillMaxSize()) {
            state.value.coins?.let { list ->
                items(list) { coin ->
                    CoinListItem(
                        coin = coin,
                        onItemClick = { navController.navigate(Screens.CoinDetailScreen.route + "/${coin.id}") }
                    )
                }
            }
        }
        if(state.value.error?.isNotBlank() == true){
            Text("error")
        }
    }*/

    //if(stateTodo.value.isLoading) Text("todo list loading...")
    Column(Modifier.fillMaxSize()) {
        LazyColumn(Modifier.fillMaxSize()) {
            todopager.let { list ->
                items(list.itemCount) { todo ->
                    list[todo]?.let {
                        ToDoListItem(
                            todo = it,
                            onItemClick = { navController.navigate(Screens.CoinDetailScreen.route + "/todo") }
                        )
                    }
                }
            }
        }
        if(state.value.error?.isNotBlank() == true){
            Text("error")
        }
    }
}


/*
@Composable
@Preview
fun CoinListPreview() {
    CoinListScreen(rememberNavController())
}*/
