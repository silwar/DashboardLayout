package com.silwar.dashboard.repository

import com.silwar.dashboard.model.DashboardItemResponse
import kotlinx.coroutines.flow.Flow

class DashboardRepository {
    private val localDataSource = DashboardLocalDataSource()
    fun getDashboardItems(): Flow<List<DashboardItemResponse>> {
        return localDataSource.getDashboardItems()
    }
}