package com.walcker.dailypulse.android.topazDesigner.tokens

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class TopazSpacerOrientation {
    Horizontal,
    Vertical,
}

enum class TopazSpacerSize(
    public val horizontalHeight: Dp,
    public val verticalWidth: Dp,
) {
    Small(
        horizontalHeight = 4.dp,
        verticalWidth = 4.dp,
    ),
    Medium(
        horizontalHeight = 8.dp,
        verticalWidth = 8.dp,
    ),
    Large(
        horizontalHeight = 12.dp,
        verticalWidth = 12.dp,
    ),
}