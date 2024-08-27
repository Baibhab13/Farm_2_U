package com.example.farm_2_u.pages

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.farm_2_u.Homepage
import com.example.farm_2_u.TopBar


@Composable
fun Sell_page(navController: NavHostController) {
    TopBar()
    Button(
        onClick = {
            navController.navigate(Homepage.route)
        }
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun TopbarPreview() {
    TopBar()
}
