package com.example.mybookscomposeapp.ui.screen.favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.mybookscomposeapp.R
import com.example.mybookscomposeapp.data.Book
import com.example.mybookscomposeapp.ui.components.BookList
import com.example.mybookscomposeapp.ui.components.CustomTopAppBar

@Composable
fun FavoriteScreen() {
    Text(text = "Ini halaman favorite")
}

@Composable
fun FavoriteContent(
    favoriteBooks: List<Book>,
    navigateToDetail: (Long) -> Unit,
    onBackClick: () -> Unit,
) {
    Column {
        CustomTopAppBar(screenName = R.string.favorite_screen, onBackClick)
        BookList(books = favoriteBooks, navigateToDetail = navigateToDetail)
    }
}