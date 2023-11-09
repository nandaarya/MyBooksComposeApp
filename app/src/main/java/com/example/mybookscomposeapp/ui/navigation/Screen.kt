package com.example.mybookscomposeapp.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Favorite : Screen("favorite")
    object About : Screen("about")
    object Add : Screen("home/add")
    object Detail : Screen("home/{bookId}") {
        fun createRoute(bookId: Long) = "home/$bookId"
    }
}