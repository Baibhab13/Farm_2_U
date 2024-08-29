package com.example.farm_2_u.pages

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.farm_2_u.GetOTP_page
import com.example.farm_2_u.R

@Composable
fun Login_page(navController: NavHostController) {
    val num = remember { mutableStateOf("") }
    val context = LocalContext.current
    val bgcolor = colorResource(id = R.color.c1)
    val navController = rememberNavController()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bgcolor)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Login page",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(20.dp))

        Image(
            painter = painterResource(id = R.drawable.no_bg_logo_1),
            contentDescription ="logo",
            modifier = Modifier.width(200.dp)
        )

        Spacer(modifier = Modifier.padding(20.dp))

        OutlinedTextField(
            value = num.value,
            onValueChange = {
                    newtxt -> num.value = newtxt
            },
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth(),
            label = { Text("Number") },
            placeholder = { Text("Enter your number") }
        )

        Spacer(modifier = Modifier.padding(2.dp))

        Button(onClick = {
            navController.navigate(GetOTP_page.route)
            Toast.makeText(context, "OTP Sent", Toast.LENGTH_SHORT).show()
        },
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.c4))

        ) {
            Text(
                text = "Get OTP",
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.padding(50.dp))

        TextButton(onClick = { /*TODO*/ }) {
            Text(
                text = "Register! New User",
                style = TextStyle(
                    color = Color.Blue
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    val navController = rememberNavController()
    Login_page(navController)
}