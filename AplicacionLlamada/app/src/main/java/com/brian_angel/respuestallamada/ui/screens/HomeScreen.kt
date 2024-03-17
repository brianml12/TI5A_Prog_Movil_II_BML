package com.brian_angel.respuestallamada.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.brian_angel.respuestallamada.R
import com.brian_angel.respuestallamada.ui.viewmodels.HomeViewModel

@Composable
fun HomeScreenUI(homeViewModel: HomeViewModel){
    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            contentHomeScreenUI(homeViewModel)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun contentHomeScreenUI(homeViewModel: HomeViewModel){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
                title = { Text("Aplicacion de llamadas", color = MaterialTheme.colorScheme.onPrimary) },
            )
        },
        content = {
            contentScaffold(homeViewModel)
        }
    )
}

@Composable
fun contentScaffold(homeViewModel: HomeViewModel){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = dimensionResource(R.dimen.padding_top_column), bottom = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    dimensionResource(R.dimen.padding_start_textField),
                    end = dimensionResource(R.dimen.padding_end_textField)
                ),
            value = homeViewModel.getPhoneNumer(),
            onValueChange = { value ->
                homeViewModel.setPhoneNumber(value)
            },
            label = { Text("Ingresa el numero de telefono") }
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    dimensionResource(R.dimen.padding_start_textField),
                    end = dimensionResource(R.dimen.padding_end_textField)
                ),
            value = homeViewModel.getMessage(),
            onValueChange = { value ->
                homeViewModel.setMessage(value)
            },
            label = { Text("Ingresa el mensaje") }
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    dimensionResource(R.dimen.padding_start_textField),
                    end = dimensionResource(R.dimen.padding_end_textField)
                ),
            onClick = {
                homeViewModel.saveNumberMessage()
            }
        ) {
            Text("Guardar")
        }
    }
}

