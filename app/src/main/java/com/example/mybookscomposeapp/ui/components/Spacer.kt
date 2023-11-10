package com.example.mybookscomposeapp.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun HeightSpacer(height: Dp, modifier: Modifier = Modifier) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun WidthSpacer(width: Dp, modifier: Modifier = Modifier) {
    Spacer(modifier = Modifier.width(width))
}