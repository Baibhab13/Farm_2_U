package com.example.farm_2_u.pages

//import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.farm_2_u.Loginpage
import com.example.farm_2_u.R
//import com.example.farm_2_u.VideoPlayer

@Composable
fun Landing_page(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg_logo_landing_page_03),
                contentDescription = "background logo",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.aspectRatio(16f / 8f)
            )
            Button(
                onClick = {
                    navController.navigate(Loginpage.route)
                },
                modifier = Modifier
                    .align(Alignment.BottomEnd) // Aligns the button to the center-right
                    .padding(bottom = 16.dp, end = 16.dp) // Adds padding from the right edge
            ) {
                Text(
                    text = "Login",
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
        }

        Image(
            painter = painterResource(id = R.drawable.no_bg_logo_1),
            contentDescription ="logo",
            modifier = Modifier.width(200.dp)
                .align(Alignment.CenterHorizontally)
                .padding(20.dp)
        )

        Text(
            text = "Why choose Farm2U",
            fontSize = 32.sp, // Correct attribute name
            color = colorResource(id = R.color.teal_700),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp), // Optional: add padding to the top
            fontWeight = FontWeight.Bold // Make the text bold
        )

        Image(
            painter = painterResource(id = R.drawable.features_img),
            contentDescription = "Features",
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = "Frequently Asked Questions",
            fontSize = 25.sp,
            color = colorResource(id = R.color.teal_700),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp), // Optional: add padding to the top
            fontWeight = FontWeight.Bold // Make the text bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LandingPagePreview() {
    val navController = rememberNavController()
    Landing_page(navController)
}