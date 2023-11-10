package com.example.mybookscomposeapp.ui.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mybookscomposeapp.data.Book
import com.example.mybookscomposeapp.data.Repository
import com.example.mybookscomposeapp.ui.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavoriteViewModel(private val repository: Repository) : ViewModel() {
//    private val _favoriteBooks = MutableStateFlow<List<Book>>()
//    val favoriteBooks: StateFlow<List<Book>> get() = _favoriteBooks

    private val _uiState: MutableStateFlow<UiState<List<Book>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Book>>>
        get() = _uiState

    fun getFavoriteBooks() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getFavoriteBook()
                .sortedBy { it.bookTitle })
        }
    }
}