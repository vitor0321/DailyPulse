package com.walcker.dailypulse.android.topazDesigner.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun TopazError(
    modifier: Modifier = Modifier,
    title: String? = null,
    message: String,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        title?.let {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center
                )
            )
        }
        TopazVerticalSpacer()
        Text(
            text = message,
            style = TextStyle(
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            )
        )
    }
}