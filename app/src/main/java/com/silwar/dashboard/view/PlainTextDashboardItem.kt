package com.silwar.dashboard.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.silwar.dashboard.model.ContainerSize
import com.silwar.dashboard.model.ContainerStyle
import com.silwar.dashboard.model.PlainTextDashboardItemModel

@Composable
fun PlainTextDashboardItem(
    modifier: Modifier = Modifier,
    model: PlainTextDashboardItemModel
) {
    DashboardItemContainer(
        modifier = modifier,
        model = model
    ) {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(),
            text = model.text,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun PlainTextDashboardItemPreview() {
    val model = PlainTextDashboardItemModel(
        containerStyle = ContainerStyle.RECTANGLE,
        containerSize = ContainerSize.LARGE,
        identifier = 1,
        order = 1,
        text = "This is Preview text"
    )
    PlainTextDashboardItem(model = model)
}