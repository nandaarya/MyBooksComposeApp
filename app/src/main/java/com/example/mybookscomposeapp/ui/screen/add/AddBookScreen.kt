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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mybookscomposeapp.R
import com.example.mybookscomposeapp.di.Injection
import com.example.mybookscomposeapp.ui.ViewModelFactory
import com.example.mybookscomposeapp.ui.components.CustomTopAppBar
import com.example.mybookscomposeapp.ui.components.TextField
import com.example.mybookscomposeapp.ui.navigation.Screen
import com.example.mybookscomposeapp.ui.theme.Typography

@Composable
fun AddBookScreen(
    addBookViewModel: AddBookViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository(LocalContext.current)
        )
    ),
    navigateBack: () -> Unit,
    navController: NavController,
) {
    var bookCoverURL by remember { mutableStateOf("") }
    var bookTitle by remember { mutableStateOf("") }
    var authorName by remember { mutableStateOf("") }
    var publicationYear by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var synopsis by remember { mutableStateOf("") }

    Column {
        CustomTopAppBar(screenName = R.string.add_screen, navigateBack)
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = stringResource(R.string.add_new_book),
                style = Typography.titleLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            TextField(
                label = stringResource(R.string.book_cover_url_label),
                hint = stringResource(R.string.enter_url_book_cover),
                input = bookCoverURL,
                modifier = Modifier,
            ) { newInput ->
                bookCoverURL = newInput
            }
            TextField(
                label = stringResource(R.string.book_title_label),
                hint = stringResource(R.string.enter_book_title),
                input = bookTitle,
                modifier = Modifier,
            ) { newInput ->
                bookTitle = newInput
            }
            TextField(
                label = stringResource(R.string.author_name_label),
                hint = stringResource(R.string.enter_author_name),
                input = authorName,
                modifier = Modifier,
            ) { newInput ->
                authorName = newInput
            }
            TextField(
                label = stringResource(R.string.publication_year_label),
                hint = stringResource(R.string.enter_publication_year),
                input = publicationYear,
                modifier = Modifier,
            ) { newInput ->
                publicationYear = newInput
            }
            TextField(
                label = stringResource(R.string.category_label),
                hint = stringResource(R.string.enter_category),
                input = category,
                modifier = Modifier,
            ) { newInput ->
                category = newInput
            }
            TextField(
                label = stringResource(R.string.synopsis_label),
                hint = stringResource(R.string.enter_synopsis),
                input = synopsis,
                modifier = Modifier,
            ) { newInput ->
                synopsis = newInput
            }
            Button(
                onClick = {
                    addBookViewModel.saveBook(
                        bookCoverURL,
                        bookTitle,
                        authorName,
                        publicationYear,
                        category,
                        synopsis
                    )
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Home.route) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(R.string.add_book))
            }
        }
    }
}