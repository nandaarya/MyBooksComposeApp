package com.example.mybookscomposeapp.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mybookscomposeapp.data.Book
import com.example.mybookscomposeapp.data.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(private val repository: Repository) : ViewModel() {
    private val _filteredBooks = MutableStateFlow(
        repository.getBooks()
            .sortedBy { it.bookTitle }
    )
    val filteredBooks: StateFlow<List<Book>> get() = _filteredBooks

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query
    fun search(newQuery: String) {
        _query.value = newQuery
        _filteredBooks.value = repository.searchBooks(_query.value)
            .sortedBy { it.bookTitle }
    }
}