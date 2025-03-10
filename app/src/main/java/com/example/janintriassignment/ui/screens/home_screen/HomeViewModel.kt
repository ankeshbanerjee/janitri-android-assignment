package com.example.janintriassignment.ui.screens.home_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.janintriassignment.data.db.model.HealthData
import com.example.janintriassignment.data.db.repository.HealthDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: HealthDataRepository
): ViewModel() {

    private val _healthData = MutableStateFlow<List<HealthData>>(emptyList())
    val healthData = _healthData.asStateFlow()

    fun addHealthData(hd: HealthData) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repository.insertData(hd)
            }catch (e: Exception) {
                Log.e("HomeViewModel", "Error inserting data $e")
            }
        }
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllData().collect {data ->
                Log.d("HomeViewModel", "Data: ${data}")
                _healthData.update {data}
            }
        }
    }
}