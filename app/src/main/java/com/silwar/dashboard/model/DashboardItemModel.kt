package com.silwar.dashboard.model

import androidx.annotation.DrawableRes

interface DashboardItemModel {
    val identifier: Int
    val order: Int
    val containerStyle: ContainerStyle
    val containerSize: ContainerSize
}

data class PlainTextDashboardItemModel(
    override val identifier: Int,
    override val order: Int,
    override val containerStyle: ContainerStyle,
    override val containerSize: ContainerSize,
    val text: String
) : DashboardItemModel

data class ImageDashboardItemModel(
    override val identifier: Int,
    override val order: Int,
    override val containerStyle: ContainerStyle,
    override val containerSize: ContainerSize,
    @DrawableRes val imageId: Int
): DashboardItemModel