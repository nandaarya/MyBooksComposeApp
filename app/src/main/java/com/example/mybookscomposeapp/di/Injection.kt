package com.example.mybookscomposeapp.di

import com.example.mybookscomposeapp.data.Repository

object Injection {
    fun provideRepository(): Repository {
        return Repository.getInstance()
    }
}