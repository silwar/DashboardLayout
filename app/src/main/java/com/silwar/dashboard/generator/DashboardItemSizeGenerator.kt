package com.silwar.dashboard.generator

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.silwar.dashboard.PADDING_CONTAINER_OFFSET_DP
import com.silwar.dashboard.PADDING_CONTENT_DP
import com.silwar.dashboard.model.ContainerSize
import com.silwar.dashboard.model.ContainerStyle

fun getContainerModifier(
    modifier: Modifier,
    containerStyle: ContainerStyle,
    containerSize: ContainerSize,
    configuration: Configuration
): Modifier {
    val screenWidth = configuration.screenWidthDp.dp - PADDING_CONTAINER_OFFSET_DP
    val width = screenWidth / containerSize.factor
    return when (containerStyle) {
        ContainerStyle.RECTANGLE -> setRectangleSize(
            modifier,
            width
        )

        ContainerStyle.SQUARE -> setSquareSize(
            modifier,
            width
        )
    }.padding(PADDING_CONTENT_DP)
}


fun setRectangleSize(
    modifier: Modifier,
    width: Dp,
): Modifier {
    val height = width * 0.4f
    return modifier.size(width, height)
}

fun setSquareSize(
    modifier: Modifier,
    width: Dp,
): Modifier {
    return modifier.size(width, width)
}