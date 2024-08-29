package com.example.farm_2_u

import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*


// VIDEO PLAYER COMPONENT
@Composable
fun VideoPlayer(videoUri: Uri) {
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp)),
        factory = { context ->
            VideoView(context).apply {
                setVideoURI(videoUri)

                val mediaController = MediaController(context)
                mediaController.setAnchorView(this)

                setMediaController(mediaController)

                setOnPreparedListener {
                    start()
                }
            }
        }
    )
}

// CUSTOM OTP TEXT FIELD
@Composable
fun OTPTextField(
    modifier: Modifier = Modifier,
    length: Int,
    onField: (code: String) -> Unit
) {
    var code by remember { mutableStateOf(List(length) { "" }) }
    val focusRequesters: List<FocusRequester> = remember {
        List(length) { FocusRequester() }
    }

    Row(
        modifier = modifier.height(50.dp)
    ) {
        (0 until length).forEach { index ->
            OutlinedTextField(
                value = code[index],
                onValueChange = { value ->
                    if (value.length <= 1) {
                        val newCode = code.toMutableList().apply {
                            this[index] = value
                        }
                        code = newCode
                        onField(newCode.joinToString(""))

                        if (value.isNotEmpty() && index < length - 1) {
                            focusRequesters[index + 1].requestFocus()
                        } else if (value.isEmpty() && index > 0) {
                            focusRequesters[index - 1].requestFocus()
                        }
                    }
                },
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .focusRequester(focusRequesters[index]),
                textStyle = MaterialTheme.typography.bodyMedium.copy(
                    textAlign = TextAlign.Center,
                    color = Color.Black
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.width(15.dp))
        }
    }
}

// GRID CELL COMPONENT
@Composable
fun LazyGrid() {
    LazyVerticalGrid(columns = GridCells.Adaptive(140.dp)) {
        items(10) {
            MyGridCell()
        }
    }
}

@Composable
fun MyGridCell() {
    Card(
        modifier = Modifier.padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.no_bg_logo_1),
                contentDescription = "Greek Salad",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Greek Salad",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .align(Alignment.TopStart)

            )
            Text(
                text = "30Rs/Kg",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(Color.White)
                    .padding(start = 4.dp, end = 4.dp)
                    .align(Alignment.BottomEnd)

            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    // Scaffold provides a structure with optional slots for TopAppBar, BottomAppBar, etc.
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My App") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle navigation icon press */ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Handle chat icon press */ }) {
                        Icon(Icons.Filled.DateRange, contentDescription = "Chat")
                    }
                    IconButton(onClick = { /* Handle analytics icon press */ }) {
                        Icon(Icons.Filled.AccountCircle, contentDescription = "Analytics")
                    }
                }
            )
        },
        content = { paddingValues ->
            // The content of the screen goes here, inside the scaffold's body
            Text(
                text = "Hello, World!",
                modifier = Modifier.padding(paddingValues)
            )
        }
    )
}
