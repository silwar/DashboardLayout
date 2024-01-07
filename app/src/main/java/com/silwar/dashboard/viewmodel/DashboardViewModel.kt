package com.silwar.dashboard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silwar.dashboard.generator.dashboardItemState
import com.silwar.dashboard.interactor.DashboardInteractor
import com.silwar.dashboard.model.DashboardItemState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class DashboardViewModel : ViewModel() {
    val uiState = MutableStateFlow(DashboardItemState())
    private val interactor = DashboardInteractor()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getDashboardItems()
        }
    }

    private suspend fun getDashboardItems() {
        interactor
            .getDashboardItems()
            .collect { response ->
                val model = dashboardItemState(response)
                uiState.value = uiState.value.copy(
                    items = model.items
                )
            }
    }
}