package com.example.farm_2_u.pages

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.farm_2_u.Loginpage
import com.example.farm_2_u.R
import com.example.farm_2_u.VideoPlayer

@Composable
fun Landing_page(navController: NavHostController) {
    val videoUri = Uri.parse("android.resource://com.example.farm_2_u/raw/vdo") // Ensure the video exists in res/raw

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        VideoPlayer(videoUri = videoUri)

        Button(onClick = {
            navController.navigate(Loginpage.route)
        },
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.c4))

        ) {
            Text (
                text = "Login",
                color = Color.White
            )//fhfdhdr
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LandingPagePreview() {
    val navController = rememberNavController()
    Landing_page(navController)
}