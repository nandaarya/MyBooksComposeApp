package com.example.mybookscomposeapp.ui.screen.favorite

import androidx.lifecycle.ViewModel
import com.example.mybookscomposeapp.data.Book
import com.example.mybookscomposeapp.data.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FavoriteViewModel(private val repository: Repository) : ViewModel() {
    private val _favoriteBooks = MutableStateFlow(
        repository.getFavoriteBook()
            .sortedBy { it.bookTitle }
    )
    val favoriteBooks: StateFlow<List<Book>> get() = _favoriteBooks

//    private fun getFavoriteUser() {
//        val liveData = repository.getFavoriteUser()
//        _favoriteUserList.addSource(liveData) { favoriteUserList ->
//            val convertedList = favoriteUserList.map { favoriteUser ->
//                ItemsItem(favoriteUser.username, favoriteUser.avatarUrl ?: "")
//            }
//            _favoriteUserList.value = convertedList
//        }
//    }
}