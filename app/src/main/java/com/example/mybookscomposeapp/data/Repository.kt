package com.example.mybookscomposeapp.data

class Repository {
    fun getBooks(): List<Book> {
        return BookData.books
    }

    fun searchBooks(query: String): List<Book>{
        return BookData.books.filter {
            it.bookTitle.contains(query, ignoreCase = true)
        }
    }
}