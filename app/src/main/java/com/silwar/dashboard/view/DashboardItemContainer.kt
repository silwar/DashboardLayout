package com.silwar.dashboard.view

import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import com.silwar.dashboard.generator.getContainerModifier
import com.silwar.dashboard.model.DashboardItemModel

@Composable
fun DashboardItemContainer(
    modifier: Modifier = Modifier,
    model: DashboardItemModel,
    content: @Composable () -> Unit
) {
    val configuration = LocalConfiguration.current
    ElevatedCard(
        modifier = getContainerModifier(
            modifier,
            model.containerStyle,
            model.containerSize,
            configuration
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        content()
    }
}