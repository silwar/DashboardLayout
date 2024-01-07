package com.silwar.dashboard.repository

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.silwar.dashboard.model.DashboardItemResponse
import com.silwar.dashboard.simulation.DASHBOARD_REQUIRED_RESPONSE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DashboardLocalDataSource {

    fun getDashboardItems(): Flow<List<DashboardItemResponse>> {
        val listType = object : TypeToken<ArrayList<DashboardItemResponse>>() {}.type
        val response = Gson().fromJson<List<DashboardItemResponse>>(DASHBOARD_REQUIRED_RESPONSE, listType)
        return flow {
            emit(response)
        }
    }
}