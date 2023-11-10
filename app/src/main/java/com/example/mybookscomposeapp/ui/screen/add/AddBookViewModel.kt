package com.example.mybookscomposeapp.ui.screen.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mybookscomposeapp.data.Repository
import kotlinx.coroutines.launch

class AddBookViewModel(private val repository: Repository) : ViewModel() {

    fun saveBook(
        bookCoverURL: String,
        bookTitle: String,
        authorName: String,
        publicationYear: String,
        category: String,
        synopsis: String
    ) {
        viewModelScope.launch {
            repository.saveBook(
                bookCoverURL,
                bookTitle,
                authorName,
                publicationYear,
                category,
                synopsis
            )
        }
    }
}