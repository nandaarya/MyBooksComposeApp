package com.example.mybookscomposeapp.ui.screen.favorite

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mybookscomposeapp.data.BookData
import com.example.mybookscomposeapp.di.Injection
import com.example.mybookscomposeapp.ui.ViewModelFactory
import com.example.mybookscomposeapp.ui.components.BookList

@Composable
fun FavoriteScreen(
    favoriteViewModel: FavoriteViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateToDetail: (Long) -> Unit,
) {
    BookList(books = emptyList(), navigateToDetail = navigateToDetail)
}