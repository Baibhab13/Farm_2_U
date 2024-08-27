package com.example.farm_2_u

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.farm_2_u.pages.Landing_page
import com.example.farm_2_u.pages.Login_page
import com.example.farm_2_u.pages.GetOTP_page
import com.example.farm_2_u.pages.Home_page
import com.example.farm_2_u.pages.Sell_page

@Composable
fun MyappNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Landingpage.route, builder = {
        composable(Landingpage.route) {
            Landing_page(navController = navController)
        }
        composable(Loginpage.route) {
            Login_page(navController = navController)
        }
        composable(GetOTP_page.route) {
            GetOTP_page(navController = navController)
        }
        composable(Homepage.route) {
            Home_page(navController = navController)
        }
        composable(Homepage.route) {
            Sell_page(navController = navController)
        }
    })
}
