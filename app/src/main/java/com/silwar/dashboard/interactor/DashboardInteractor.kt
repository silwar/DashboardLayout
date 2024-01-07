package com.silwar.dashboard.interactor

import com.silwar.dashboard.model.DashboardItemResponse
import com.silwar.dashboard.repository.DashboardRepository
import kotlinx.coroutines.flow.Flow

class DashboardInteractor {
    private val repository = DashboardRepository()

    fun getDashboardItems(): Flow<List<DashboardItemResponse>> {
        return repository.getDashboardItems()
    }
}