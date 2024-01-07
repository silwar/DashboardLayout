package com.silwar.dashboard.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.silwar.dashboard.PADDING_CONTAINER_DP
import com.silwar.dashboard.model.DashboardItemState
import com.silwar.dashboard.model.ImageDashboardItemModel
import com.silwar.dashboard.model.PlainTextDashboardItemModel
import com.silwar.dashboard.viewmodel.DashboardViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DashboardItem(
    state: DashboardItemState,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    FlowRow(
        modifier = modifier
            .verticalScroll(scrollState)
            .background(Color.LightGray)
            .padding(PADDING_CONTAINER_DP)
    ) {
        state.items.forEach {
            when (it) {
                is PlainTextDashboardItemModel -> PlainTextDashboardItem(
                    model = it
                )

                is ImageDashboardItemModel -> ImageDashboardItem(
                    model = it
                )
            }
        }
    }
}

@Preview
@Composable
fun DashboardContainerItemPreview() {
    val viewModel = DashboardViewModel()
    DashboardItem(
        viewModel.uiState.collectAsState().value
    )
}