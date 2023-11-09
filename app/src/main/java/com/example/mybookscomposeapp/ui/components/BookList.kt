package com.example.mybookscomposeapp.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mybookscomposeapp.data.Book
import com.example.mybookscomposeapp.data.BookData
import com.example.mybookscomposeapp.ui.theme.MyBooksComposeAppTheme

@Composable
fun BookList(
    books: List<Book>,
    navigateToDetail: (Long) -> Unit,
) {
    Surface(
        color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()
    ) {
        if (books.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Text(text = "No Books Saved :(")
            }
        } else {
            LazyColumn {
                items(items = books, key = {it.id} ) { book ->
                    BookItem(photoUrl = book.bookCoverURL,
                        bookTitle = book.bookTitle,
                        synopsis = book.synopsis,
                        modifier = Modifier.clickable {
                            navigateToDetail(book.id)
                        })
                }
            }
        }
    }
}