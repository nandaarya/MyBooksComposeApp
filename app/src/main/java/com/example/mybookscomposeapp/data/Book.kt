package com.example.mybookscomposeapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long,

    @ColumnInfo(name = "book_cover_url")
    var bookCoverURL: String,

    @ColumnInfo(name = "book_title")
    var bookTitle: String,

    @ColumnInfo(name = "author_name")
    var authorName: String,

    @ColumnInfo(name = "publication_year")
    var publicationYear: String,

    @ColumnInfo(name = "category")
    var category: String,

    @ColumnInfo(name = "synopsis")
    var synopsis: String
)