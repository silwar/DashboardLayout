package com.silwar.dashboard.generator

import com.silwar.dashboard.model.ContainerSize
import com.silwar.dashboard.model.ContainerStyle
import com.silwar.dashboard.model.ContentType
import com.silwar.dashboard.model.DashboardItemModel
import com.silwar.dashboard.model.DashboardItemState
import com.silwar.dashboard.model.DashboardItemResponse
import com.silwar.dashboard.model.ImageDashboardItemModel
import com.silwar.dashboard.model.PlainTextDashboardItemModel

fun dashboardItemState(response: List<DashboardItemResponse>): DashboardItemState {
    val itemList = arrayListOf<DashboardItemModel>()
    val sortedList = response.sortedBy { it.order }
    sortedList.forEach {
        val item = it.getDashboardItem()
        item?.let {
            itemList.add(item)
        }
    }
    return DashboardItemState(itemList)
}

fun DashboardItemResponse.getDashboardItem(): DashboardItemModel? {
    return when (ContentType.values().firstOrNull { it.value == this.contentType }) {
        ContentType.IMAGE -> getImageDashboardItem()
        ContentType.PLAIN_TEXT -> getPlainTextDashboardItem()
        else -> null
    }
}

fun DashboardItemResponse.getImageDashboardItem(): ImageDashboardItemModel {
    val containerSize: ContainerSize =
        ContainerSize.values().first { it.value == this.size }
    val containerStyle: ContainerStyle =
        ContainerStyle.values().first { it.value == this.style }
    return ImageDashboardItemModel(
        identifier = identifier,
        order = order,
        containerSize = containerSize,
        containerStyle = containerStyle,
        imageId = ImageFactory.getDrawable(this.content.imageId)
    )
}

fun DashboardItemResponse.getPlainTextDashboardItem(): PlainTextDashboardItemModel {
    val containerSize: ContainerSize =
        ContainerSize.values().first { it.value == this.size }
    val containerStyle: ContainerStyle =
        ContainerStyle.values().first { it.value == this.style }
    return PlainTextDashboardItemModel(
        identifier = identifier,
        order = order,
        containerSize = containerSize,
        containerStyle = containerStyle,
        text = this.content.label?.text ?: ""
    )
}