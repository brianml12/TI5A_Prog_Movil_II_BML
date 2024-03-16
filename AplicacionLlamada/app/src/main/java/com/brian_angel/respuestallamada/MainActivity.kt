package com.brian_angel.respuestallamada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.brian_angel.respuestallamada.navegation.AppNavigation
import com.brian_angel.respuestallamada.ui.screens.HomeViewModel
import com.brian_angel.respuestallamada.ui.theme.RespuestaLlamadaTheme
import com.brian_angel.respuestallamada.ui.screens.HomeViewModelFactory

class MainActivity : ComponentActivity() {
    private lateinit var homeViewModel : HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        homeViewModel = HomeViewModelFactory().create(HomeViewModel::class.java)
        super.onCreate(savedInstanceState)
        setContent {
            RespuestaLlamadaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation(homeViewModel)
                }
            }
        }
    }
}
