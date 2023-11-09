package com.example.mybookscomposeapp.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mybookscomposeapp.data.Book

@Database(entities = [Book::class], version = 1)
abstract class FavoriteBookDatabase: RoomDatabase() {

    abstract fun favoriteBookDao(): FavoriteBookDAO

    companion object {
        @Volatile
        private var INSTANCE: FavoriteBookDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): FavoriteBookDatabase {
            if (INSTANCE == null) {
                synchronized(FavoriteBookDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        FavoriteBookDatabase::class.java, "favorite_user_database"
                    )
                        .build()
                }
            }
            return INSTANCE as FavoriteBookDatabase
        }
    }
}