package com.example.janintriassignment.data.db.repository

import com.example.janintriassignment.data.db.dao.HealthDataDao
import com.example.janintriassignment.data.db.model.HealthData

class HealthDataRepository (
    private val healthDataDao: HealthDataDao
) {
    fun getAllData() = healthDataDao.getAllData()
    suspend fun insertData(healthData: HealthData) = healthDataDao.insertData(healthData)
}