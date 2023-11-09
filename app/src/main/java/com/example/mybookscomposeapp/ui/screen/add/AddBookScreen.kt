package com.example.mybookscomposeapp.ui.screen.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mybookscomposeapp.R
import com.example.mybookscomposeapp.ui.components.CustomTopAppBar
import com.example.mybookscomposeapp.ui.components.TextField
import com.example.mybookscomposeapp.ui.theme.Typography
import java.time.format.TextStyle

@Composable
fun AddBookScreen(
    navigateBack: () -> Unit,
) {
    Column {
        CustomTopAppBar(screenName = R.string.add_screen, navigateBack)
        AddBookContent()
    }
}

@Composable
fun AddBookContent() {
    var bookCoverURL by remember { mutableStateOf("") }
    var bookTitle by remember { mutableStateOf("") }
    var authorName by remember { mutableStateOf("") }
    var publicationYear by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var synopsis by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Masukkan Data Buku Baru",
            style = Typography.titleLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
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
        Button(
            onClick = {

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Tambah Buku")
        }
    }
}