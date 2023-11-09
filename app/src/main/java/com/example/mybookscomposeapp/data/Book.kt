package com.example.mybookscomposeapp.data

data class Book(
    val id: Long,
    var bookCoverURL: String,
    var bookTitle: String,
    var authorName: String,
    var publicationYear: String,
    var category: String,
    var synopsis: String
)