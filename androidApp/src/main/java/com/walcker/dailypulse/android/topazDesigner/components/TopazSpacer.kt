package com.walcker.dailypulse.android.topazDesigner.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.walcker.dailypulse.android.topazDesigner.tokens.TopazSpacerOrientation
import com.walcker.dailypulse.android.topazDesigner.tokens.TopazSpacerSize

@Composable
public fun TopazHorizontalSpacer(
    modifier: Modifier = Modifier,
    size: TopazSpacerSize = TopazSpacerSize.Small,
) {
    TopazSpacer(
        modifier = modifier,
        orientation = TopazSpacerOrientation.Horizontal,
        size = size
    )
}

@Composable
public fun TopazVerticalSpacer(
    modifier: Modifier = Modifier,
    size: TopazSpacerSize = TopazSpacerSize.Small,
) {
    TopazSpacer(
        modifier = modifier,
        orientation = TopazSpacerOrientation.Vertical,
        size = size
    )
}

@Composable
private fun TopazSpacer(
    modifier: Modifier = Modifier,
    orientation: TopazSpacerOrientation,
    size: TopazSpacerSize,
) {
    val orientationModifier = when (orientation) {
        TopazSpacerOrientation.Vertical ->
            Modifier
                .fillMaxWidth()
                .height(size.horizontalHeight)

        TopazSpacerOrientation.Horizontal ->
            Modifier
                .fillMaxHeight()
                .width(size.verticalWidth)
    }

    Spacer(modifier = modifier.then(orientationModifier))
}