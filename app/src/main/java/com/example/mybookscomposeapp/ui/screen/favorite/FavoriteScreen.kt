package com.example.mybookscomposeapp.ui.screen.favorite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mybookscomposeapp.di.Injection
import com.example.mybookscomposeapp.ui.UiState
import com.example.mybookscomposeapp.ui.ViewModelFactory
import com.example.mybookscomposeapp.ui.components.BookList
import com.example.mybookscomposeapp.ui.screen.detail.DetailContent

@Composable
fun FavoriteScreen(
    favoriteViewModel: FavoriteViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))
    ),
    navigateToDetail: (Long) -> Unit,
) {
    favoriteViewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                favoriteViewModel.getFavoriteBooks()
            }

            is UiState.Success -> {
                val favoriteBooks = uiState.data
                BookList(books = favoriteBooks, navigateToDetail = navigateToDetail)
            }

            is UiState.Error -> {}
        }
    }
//    val favoriteBooks by favoriteViewModel.favoriteBooks.collectAsState()

}