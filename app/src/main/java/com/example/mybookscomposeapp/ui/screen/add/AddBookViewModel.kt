package com.example.mybookscomposeapp.ui.screen.add

import android.util.Log
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
            Log.d(
                "addBookViewModel", "$bookCoverURL,\n" +
                        "$bookTitle,\n" +
                        "$authorName,\n" +
                        "$publicationYear,\n" +
                        "$category,\n" +
                        synopsis
            )
        }
    }
}