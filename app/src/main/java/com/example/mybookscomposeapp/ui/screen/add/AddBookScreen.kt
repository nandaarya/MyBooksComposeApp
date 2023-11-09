package com.example.mybookscomposeapp.ui.screen.add

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mybookscomposeapp.R
import com.example.mybookscomposeapp.ui.components.TextField

@Composable
fun AddBookScreen() {
    AddBookContent()
}

@Composable
fun AddBookContent() {
    var bookCoverURL by remember { mutableStateOf("") }
    var bookTitle by remember { mutableStateOf("") }
    var authorName by remember { mutableStateOf("") }
    var publicationYear by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var synopsis by remember { mutableStateOf("") }

    Column {
        Text(text = "Masukkan Data Buku Baru")
        TextField(
            label = stringResource(R.string.book_cover_url_label),
            hint = stringResource(
                R.string.text_field_hint,
                stringResource(R.string.book_cover_url_label)
            ),
            input = bookCoverURL,
            onValueChange = { newInput ->
                bookCoverURL = newInput
            })
        TextField(
            label = stringResource(R.string.book_title_label),
            hint = stringResource(
                R.string.text_field_hint,
                stringResource(R.string.book_title_label)
            ),
            input = bookTitle,
            onValueChange = { newInput ->
                bookTitle = newInput
            })
        TextField(
            label = stringResource(R.string.author_name_label),
            hint = stringResource(
                R.string.text_field_hint,
                stringResource(R.string.author_name_label)
            ),
            input = authorName,
            onValueChange = { newInput ->
                authorName = newInput
            })
        TextField(
            label = stringResource(R.string.publication_year_label),
            hint = stringResource(
                R.string.text_field_hint,
                stringResource(R.string.publication_year_label)
            ),
            input = publicationYear,
            onValueChange = { newInput ->
                publicationYear = newInput
            })
        TextField(
            label = stringResource(R.string.category_label),
            hint = stringResource(
                R.string.text_field_hint,
                stringResource(R.string.category_label)
            ),
            input = category,
            onValueChange = { newInput ->
                category = newInput
            })
        TextField(
            label = stringResource(R.string.synopsis_label),
            hint = stringResource(
                R.string.text_field_hint,
                stringResource(R.string.synopsis_label)
            ),
            input = synopsis,
            onValueChange = { newInput ->
                synopsis = newInput
            })
        Button(onClick = {}) {
            Text(text = "Tambah Buku")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddBookScreenPreview() {
    AddBookScreen()
}