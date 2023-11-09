package com.example.mybookscomposeapp.di

import android.content.Context
import com.example.mybookscomposeapp.data.Repository
import com.example.mybookscomposeapp.local.FavoriteBookDatabase

object Injection {
    fun provideRepository(context: Context): Repository {
        val database = FavoriteBookDatabase.getDatabase(context)
        val dao = database.favoriteBookDao()
        return Repository.getInstance(dao)
    }
}