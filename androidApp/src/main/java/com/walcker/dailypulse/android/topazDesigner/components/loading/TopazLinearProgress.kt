package com.walcker.dailypulse.android.topazDesigner.components.loading

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
public fun TopazLinearProgress(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LinearProgressIndicator(
            modifier = modifier,
            color = MaterialTheme.colorScheme.secondary,
        )
    }
}