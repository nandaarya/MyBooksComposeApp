package com.example.mybookscomposeapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.example.mybookscomposeapp.data.books
import com.example.mybookscomposeapp.ui.components.BookItem
import com.example.mybookscomposeapp.ui.theme.MyBooksComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBooksComposeAppTheme {
                MyBooksApp()
//                BookList(books)
            }
        }
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

@Preview(showBackground = true)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun BookListPreview() {
    MyBooksComposeAppTheme {
        BookList(books)
    }
}