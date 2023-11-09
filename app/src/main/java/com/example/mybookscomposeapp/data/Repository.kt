package com.example.mybookscomposeapp.data

import android.util.Log
import com.example.mybookscomposeapp.local.FavoriteBookDAO

class Repository(
    private val favoriteBookDao: FavoriteBookDAO,
) {

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
            "$id,\n$bookCoverURL,\n$bookTitle,\n$authorName,\n$publicationYear,\n$category,\n$synopsis"
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

    suspend fun saveFavoriteBook(favoriteBook: Book) {
        favoriteBookDao.insert(favoriteBook)
    }

    suspend fun delete(favoriteBook: Book) {
        favoriteBookDao.delete(favoriteBook)
    }

    fun getFavoriteBook(): List<Book> = favoriteBookDao.getAllFavoriteUser()

    fun isFavorite(id: Int): Boolean =
        favoriteBookDao.isFavorite(id)

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(
            favoriteBookDao: FavoriteBookDAO,
        ): Repository = instance ?: synchronized(this) {
            Repository(
               favoriteBookDao
            ).apply {
                instance = this
            }
        }
    }
}