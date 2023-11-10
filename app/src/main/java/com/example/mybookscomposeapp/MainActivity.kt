package com.example.mybookscomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mybookscomposeapp.ui.theme.MyBooksComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBooksComposeAppTheme {
                MyBooksApp()
            }
        }
    }
}