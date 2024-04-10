package com.walcker.dailypulse.android.topazDesigner.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.walcker.dailypulse.android.topazDesigner.tokens.TopazDividerOrientation
import com.walcker.dailypulse.android.topazDesigner.tokens.TopazDividerSize
import com.walcker.dailypulse.android.topazDesigner.tokens.TopazDividerTokens

@Composable
public fun TopazDividerHorizontal(
    modifier: Modifier = Modifier,
    size: TopazDividerSize = TopazDividerSize.Small,
) {
    TopazSpacer(
        modifier = modifier,
        orientation = TopazDividerOrientation.Horizontal,
        size = size
    )
}

@Composable
public fun TopazDividerVertical(
    modifier: Modifier = Modifier,
    size: TopazDividerSize = TopazDividerSize.Small,
) {
    TopazSpacer(
        modifier = modifier,
        orientation = TopazDividerOrientation.Vertical,
        size = size
    )
}

@Composable
private fun TopazSpacer(
    modifier: Modifier = Modifier,
    orientation: TopazDividerOrientation = TopazDividerOrientation.Vertical,
    size: TopazDividerSize = TopazDividerSize.Small,
) {
    val orientationModifier = when (orientation) {
        TopazDividerOrientation.Horizontal ->
            Modifier
                .fillMaxWidth()
                .height(size.horizontalWidth)

        TopazDividerOrientation.Vertical ->
            Modifier
                .fillMaxHeight()
                .width(size.verticalHeight)
    }

    Divider(
        modifier = modifier
            .then(orientationModifier)
            .background(TopazDividerTokens.background)
    )
}