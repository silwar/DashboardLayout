package com.silwar.dashboard.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.silwar.dashboard.R
import com.silwar.dashboard.model.ContainerSize
import com.silwar.dashboard.model.ContainerStyle
import com.silwar.dashboard.model.ImageDashboardItemModel

@Composable
fun ImageDashboardItem(
    modifier: Modifier = Modifier,
    model: ImageDashboardItemModel,
) {
    DashboardItemContainer(
        modifier = modifier,
        model = model
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(),
            painter = painterResource(id = model.imageId),
            contentScale = ContentScale.FillHeight,
            contentDescription = "This is image"
        )
    }
}

@Preview
@Composable
fun ImageDashboardItemPreview() {
    val model = ImageDashboardItemModel(
        containerStyle = ContainerStyle.SQUARE,
        containerSize = ContainerSize.LARGE,
        identifier = 1,
        order = 1,
        imageId = R.drawable.ic_image_1
    )
    ImageDashboardItem(model = model)
}