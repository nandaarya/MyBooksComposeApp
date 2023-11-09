package com.example.mybookscomposeapp.ui.screen.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.mybookscomposeapp.R
import com.example.mybookscomposeapp.di.Injection
import com.example.mybookscomposeapp.ui.UiState
import com.example.mybookscomposeapp.ui.ViewModelFactory

@Composable
fun DetailScreen(
    bookId: Long,
    viewModel: DetailViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository()
        )
    ),
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getBookById(bookId)
            }

            is UiState.Success -> {
                val data = uiState.data
                DetailContent(
                    data.bookCover,
                    data.bookTitle,
                    data.authorName,
                    data.publicationYear,
                    data.category,
                    data.synopsis
//                    onBackClick = navigateBack,
//                    onAddToCart = { count ->
//                        viewModel.addToCart(data.reward, count)
//                        navigateToCart()
//                    }
                )
            }

            is UiState.Error -> {}
        }
    }
}

@Composable
fun DetailContent(
    bookCoverURL: String,
    bookTitle: String,
    authorName: String,
    publicationYear: String,
    category: String,
    synopsis: String,
) {
    Column {
        Text(text = "Data Buku")
        AsyncImage(
            model = bookCoverURL,
            contentDescription = bookTitle,
            modifier = Modifier.size(200.dp)
        )
        Text(text = stringResource(R.string.book_title, bookTitle))
        Text(text = stringResource(R.string.author_name, authorName))
        Text(text = stringResource(R.string.publication_year, publicationYear))
        Text(text = stringResource(R.string.category, category))
        Text(text = "Sinopsis")
        Text(text = "Isi Sinopsis")
    }
}