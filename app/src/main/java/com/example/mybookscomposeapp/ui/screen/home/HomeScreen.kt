package com.example.mybookscomposeapp.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.mybookscomposeapp.data.Book
import com.example.mybookscomposeapp.data.books
import com.example.mybookscomposeapp.ui.components.BookItem

@Composable
fun HomeScreen() {
    Column {
        Text(text = "Fitur Search")
        BookList(books = books)
    }
}

@Composable
fun BookList(
    books: List<Book>,
    modifier: Modifier = Modifier,
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        if (books.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "No Books Saved :(")
            }
        } else {
            LazyColumn {
                items(items = books) { book ->
                    BookItem(
                        photoUrl = book.bookCover,
                        bookTitle = book.bookTitle,
                        synopsis = book.synopsis
                    )
                }
            }
        }
    }
}