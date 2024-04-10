package com.walcker.dailypulse.android.topazDesigner.tokens

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object TopazDividerTokens {
    val background: Color = Color.Gray
}

enum class TopazDividerOrientation {
    Horizontal,
    Vertical,
}

enum class TopazDividerSize(
    public val horizontalWidth: Dp,
    public val verticalHeight: Dp,
) {
    Small(
        horizontalWidth = 4.dp,
        verticalHeight = 4.dp,
    ),
    Medium(
        horizontalWidth = 8.dp,
        verticalHeight = 8.dp,
    ),
    Large(
        horizontalWidth = 12.dp,
        verticalHeight = 12.dp,
    ),
}