package com.example.mybookscomposeapp.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mybookscomposeapp.data.Book
import com.example.mybookscomposeapp.data.Repository
import com.example.mybookscomposeapp.ui.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: Repository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<Book>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Book>>
        get() = _uiState

    private val _isBookSaved = MutableStateFlow(false)
    val isBookSaved: StateFlow<Boolean> get() = _isBookSaved

    fun getBookById(bookId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getBookById(bookId))
        }
    }

    fun isFavorite(bookId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            _isBookSaved.value = repository.isFavorite(bookId)
        }
    }

    fun saveFavoriteBook(favoriteBook: Book) {
        _isBookSaved.value = true
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveFavoriteBook(favoriteBook)
        }
    }

    fun deleteFavoriteBook(favoriteBook: Book): Job {
        _isBookSaved.value = false
        return viewModelScope.launch(Dispatchers.IO) {
            repository.delete(favoriteBook)
        }
    }
}