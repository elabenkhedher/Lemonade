package com.example.lemonade

import android.icu.text.CaseMap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                Scaffold(
                    topBar =  {header()},
                    containerColor = Color(0xFFFFF469)
                ){
                        innerPadding ->
                    LemonApp(Modifier.padding(innerPadding))
                }

            }
        }
    }
}
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun header (modifier: Modifier=Modifier){
    CenterAlignedTopAppBar(
        title={
            Text(
                text="Lemonade",
                fontWeight = FontWeight.Bold

            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor= Color(0XFFFFEB3B),
            titleContentColor = Color.Black
        )

    )

}
@Composable
fun LemonApp(modifier: Modifier=Modifier) {

    var currentStep by remember { mutableStateOf(1) }
    var rand =(7..12).random()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (currentStep) {
            1 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Image(
                        painter = painterResource(R.drawable.lemon_tree),
                        contentDescription = stringResource(R.string.lemon_tree_content_description),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                currentStep = 2
                            }
                            .border(
                                width = 2.dp ,
                                color=Color(105,205,216),
                                shape=RoundedCornerShape(20.dp)
                            )
                            .background(
                                color=Color(0xFFB0EFD2),
                                shape=RoundedCornerShape(20.dp)
                            )
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = stringResource(R.string.Lemon_tree))

                }
            }
            in 2 until rand -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = stringResource(R.string.lemon_content_description),
                        modifier = Modifier.wrapContentSize()
                            .clickable {
                                currentStep = currentStep+1
                            }
                            .border(
                                width = 2.dp ,
                                color=Color(105,205,216),
                                shape=RoundedCornerShape(20.dp)
                            )
                            .background(
                                color=Color(0xFFB0EFD2),
                                shape=RoundedCornerShape(20.dp)
                            )
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = stringResource(R.string.lemon))
                }
            }
            rand -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()

                ){
                    Image(
                        painter = painterResource(R.drawable.lemon_drink),
                        contentDescription = stringResource(R.string.lemon_juice_content_description),
                        modifier = Modifier.wrapContentSize()
                            .clickable {
                                currentStep = rand+1
                            }
                            .border(
                                width = 2.dp ,
                                color=Color(105,205,216),
                                shape=RoundedCornerShape(20.dp)
                            )
                            .background(
                                color=Color(0xFFB0EFD2),
                                shape=RoundedCornerShape(20.dp)
                            )
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = stringResource(R.string.lemon_juice))

                }
            }
            rand+1 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Image(
                        painter = painterResource(R.drawable.lemon_restart),
                        contentDescription = stringResource(R.string.glace_content_description),
                        modifier = Modifier.wrapContentSize()
                            .clickable {
                                currentStep = 1
                            }
                            .border(
                                width = 2.dp ,
                                color=Color(105,205,216),
                                shape=RoundedCornerShape(20.dp)
                            )
                            .background(
                                color=Color(0xFFB0EFD2),
                                shape=RoundedCornerShape(20.dp)
                            )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = stringResource(R.string.glace))
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}