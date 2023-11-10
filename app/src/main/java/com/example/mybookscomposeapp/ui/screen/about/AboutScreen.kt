package com.example.mybookscomposeapp.ui.screen.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mybookscomposeapp.R
import com.example.mybookscomposeapp.ui.theme.Typography

@Composable
fun AboutScreen() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.foto),
            contentDescription = stringResource(R.string.nanda_image),
            Modifier
                .size(320.dp)
                .clip(CircleShape)
                .padding(24.dp)
        )
        Text(text = stringResource(id = R.string.name), style = Typography.titleLarge)
        Text(text = stringResource(id = R.string.email),style = Typography.titleMedium)
    }
}