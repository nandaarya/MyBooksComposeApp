package com.example.mybookscomposeapp.data

import android.util.Log

class Repository {

    private val books = mutableListOf<Book>()

    init {
        if (books.isEmpty()) {
            BookData.dummyBooks.forEach {
                books.add(it)
            }
        }
    }

    fun getBooks(): List<Book> {
        return books
    }

    fun searchBooks(query: String): List<Book> {
        return books.filter {
            it.bookTitle.contains(query, ignoreCase = true)
        }
    }

    fun getBookById(bookId: Long): Book {
        return books.first {
            it.id == bookId
        }
    }

    fun saveBook(
        bookCoverURL: String,
        bookTitle: String,
        authorName: String,
        publicationYear: String,
        category: String,
        synopsis: String
    ){
        val id = books.last().id + 1
        Log.d(
            "repository",
            "$id,\n" + "$bookCoverURL,\n" + "$bookTitle,\n" + "$authorName,\n" + "$publicationYear,\n" + "$category,\n" + "$synopsis"
        )
        books.add(
            Book(
                id,
                bookCoverURL,
                bookTitle,
                authorName,
                publicationYear,
                category,
                synopsis
            )
        )
        Log.d("repository", books.last().toString())
    }

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(): Repository = instance ?: synchronized(this) {
            Repository().apply {
                instance = this
            }
        }
    }
}