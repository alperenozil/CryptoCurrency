package com.alperen.cryptocurrency

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alperen.cryptocurrency.ui.Screens
import com.alperen.cryptocurrency.ui.coin_detail.components.CoinDetailsScreen
import com.alperen.cryptocurrency.ui.coin_list.components.CoinListScreen
import com.alperen.cryptocurrency.ui.theme.CryptoCurrencyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoCurrencyTheme {
                val navController = rememberNavController()
                Box(modifier = Modifier.fillMaxSize()) {
                   NavHost(navController = navController, startDestination = Screens.CoinListScreen.route) {
                       composable(Screens.CoinListScreen.route){
                           CoinListScreen(navController = navController)
                       }
                       composable(Screens.CoinDetailScreen.route+"/{coinId}"){
                           CoinDetailsScreen()
                       }
                   }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CryptoCurrencyTheme {
        Greeting("Android")
    }
}