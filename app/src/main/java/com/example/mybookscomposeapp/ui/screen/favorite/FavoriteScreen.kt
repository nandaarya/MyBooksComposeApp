package com.example.mybookscomposeapp.ui.screen.favorite

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mybookscomposeapp.data.BookData
import com.example.mybookscomposeapp.di.Injection
import com.example.mybookscomposeapp.ui.ViewModelFactory
import com.example.mybookscomposeapp.ui.components.BookList

@Composable
fun FavoriteScreen(
    viewModel: FavoriteViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateToDetail: (Long) -> Unit,
) {
    BookList(books = BookData.books, navigateToDetail = navigateToDetail)
}