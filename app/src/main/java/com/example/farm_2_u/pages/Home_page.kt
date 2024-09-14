package com.example.farm_2_u.pages


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.farm_2_u.LazyGrid

@Composable
fun Home_page(navController: NavHostController) {
    AppScreen()
}

@Composable
private fun AppScreen() {
    LazyGrid()
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    val navController = rememberNavController()
    Home_page(navController)
}