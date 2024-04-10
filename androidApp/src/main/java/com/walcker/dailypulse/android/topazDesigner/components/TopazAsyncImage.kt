package com.walcker.dailypulse.android.topazDesigner.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ErrorOutline
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.walcker.dailypulse.android.topazDesigner.components.loading.TopazLinearProgress

@Composable
public fun TopazAsyncImage(
    modifier: Modifier = Modifier,
    image: String?,
) {
    var errorImage by rememberSaveable { mutableStateOf(false) }
    var loadingImage by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .sizeIn(minHeight = 200.dp),
        contentAlignment = Alignment.Center
    ) {

        if (loadingImage)
            TopazLinearProgress()

        if (errorImage)
            TopazIcon(icon = Icons.Rounded.ErrorOutline)

        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(image)
                .decoderFactory(SvgDecoder.Factory())
                .build(),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            contentDescription = null,
            onLoading = {
                errorImage = false
                loadingImage = true
            },
            onSuccess = {
                loadingImage = false
                errorImage = false
            },
            onError = {
                errorImage = true
                loadingImage = false
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ImageUriPreview() {
    TopazAsyncImage(
        image = null,
    )
}