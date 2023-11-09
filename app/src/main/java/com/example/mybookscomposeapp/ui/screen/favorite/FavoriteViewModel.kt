package com.example.mybookscomposeapp.ui.screen.favorite

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mybookscomposeapp.data.Book
import com.example.mybookscomposeapp.data.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FavoriteViewModel(private val repository: Repository) : ViewModel() {
    private val _favoriteBooks = MutableStateFlow(
        repository.getBooks()
            .sortedBy { it.bookTitle }
    )
    val favoriteBooks: StateFlow<List<Book>> get() = _favoriteBooks

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query
    fun search(newQuery: String) {
        _query.value = newQuery
        _favoriteBooks.value = repository.searchBooks(_query.value)
            .sortedBy { it.bookTitle }
    }
}