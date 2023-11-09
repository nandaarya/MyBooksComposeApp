package com.example.mybookscomposeapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mybookscomposeapp.ui.theme.MyBooksComposeAppTheme

@Composable
fun TextField(
    label: String,
    hint: String,
    input: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.titleMedium
        )
        OutlinedTextField(
            value = input,
            label = { Text(hint) },
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldPreview() {
    MyBooksComposeAppTheme {
        TextField(label = "Nama", input = "", hint = "Masukkan Nama", onValueChange = {})
    }
}