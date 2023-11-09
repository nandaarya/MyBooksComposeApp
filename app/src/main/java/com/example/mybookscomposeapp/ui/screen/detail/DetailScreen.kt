package com.example.mybookscomposeapp.ui.screen.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.mybookscomposeapp.R
import com.example.mybookscomposeapp.di.Injection
import com.example.mybookscomposeapp.ui.UiState
import com.example.mybookscomposeapp.ui.ViewModelFactory
import com.example.mybookscomposeapp.ui.theme.Typography

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
    Column(
        modifier = Modifier
            .padding(24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Data Buku",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = Typography.titleLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        AsyncImage(
            model = bookCoverURL,
            contentDescription = bookTitle,
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(R.string.book_title, bookTitle), style = Typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = stringResource(R.string.author_name, authorName), style = Typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = stringResource(R.string.publication_year, publicationYear), style = Typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = stringResource(R.string.category, category), style = Typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Sinopsis", fontWeight = FontWeight.Bold, style = Typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = synopsis, textAlign = TextAlign.Justify, style = Typography.bodyLarge)
    }
}