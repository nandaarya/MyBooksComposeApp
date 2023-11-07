package com.example.mybookscomposeapp.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Favorite : Screen("favorite")
    object Profile : Screen("profile")
    object Detail : Screen("home/{bookId}") {
        fun createRoute(bookId: Long) = "home/$bookId"
    }
}