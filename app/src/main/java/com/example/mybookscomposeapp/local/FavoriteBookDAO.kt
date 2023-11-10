package com.example.mybookscomposeapp.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mybookscomposeapp.data.Book

@Dao
interface FavoriteBookDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(favoriteBook: Book)

    @Update
    suspend fun update(favoriteUser: Book)

    @Delete
    suspend fun delete(favoriteUser: Book)

    @Query("SELECT * from Book")
    fun getAllFavoriteUser(): List<Book>

    @Query("SELECT EXISTS(SELECT * FROM Book WHERE Book.id = :bookId)")
    fun isFavorite(bookId: Long): Boolean
}