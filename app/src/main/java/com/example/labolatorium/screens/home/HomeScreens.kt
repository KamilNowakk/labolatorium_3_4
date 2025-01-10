package com.example.labolatorium.screens.home


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.labolatorium.MovieRow
import com.example.labolatorium.navigation.MovieScreens


@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Magenta,
                elevation = 5.dp
            ) {
                Text(text = "Movies")
            }
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = Color.Blue,
                elevation = 5.dp
            ) {
                Text(text = "Bottom Bar")
            }
        }
    ) { it ->
        Column(modifier = Modifier.padding(it)) {
            MainContent(navController = navController)
        }
    }
}

@Composable
fun MainContent(
    navController: NavController,
    moviesList: List<String> = listOf(
        "Inception",
        "The Matrix",
        "Breaking Dawn",
        "Winter Wonderland",
        "14.02.2023",
        "Lion",
        "Parrot",
        "Gourmet Feast"
    )
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(moviesList) { movie ->
                MovieRow(movie = movie) {
                    navController.navigate(route = MovieScreens.DetailsScreen.name + "/$movie")
                }
            }
        }
    }
}