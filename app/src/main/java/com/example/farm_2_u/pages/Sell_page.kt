package com.example.farm_2_u.pages

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.farm_2_u.TopBar


@Composable
fun Sell_page(navController: NavHostController) {
    TopBar()
}

@Preview(showBackground = true)
@Composable
fun TopbarPreview() {
    TopBar()
}
