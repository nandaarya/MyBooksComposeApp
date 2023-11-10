package com.example.mybookscomposeapp.data

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
    }

    suspend fun saveFavoriteBook(favoriteBook: Book) {
        favoriteBookDao.insert(favoriteBook)
    }

    suspend fun delete(favoriteBook: Book) {
        favoriteBookDao.delete(favoriteBook)
    }

    suspend fun getFavoriteBook(): List<Book> {
        return favoriteBookDao.getAllFavoriteUser()
    }

    fun isFavorite(bookId: Long): Boolean =
        favoriteBookDao.isFavorite(bookId)

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