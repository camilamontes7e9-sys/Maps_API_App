package com.example.mapsapiapp.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mapsapiapp.core.permissions.PermissionStatus
import com.example.mapsapiapp.model.Task
import com.example.mapsapiapp.repository.RepositoryTask
import com.example.mapsapiapp.ui.map.MapPermissionState

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MapsViewModel: ViewModel() {

    //Manage tasks
    private val repository = RepositoryTask()

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    init {
        loadTasks()
    }

    private fun loadTasks() {
        viewModelScope.launch {
            try {
                _tasks.value = repository.obtainTasks()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun addTask(title: String, lat: Float, long: Float, complete: Boolean, description: String) {
        viewModelScope.launch {
            repository.addTask(titleP = title, latP = lat, longP = long, completed = complete, descriptionP = description)
            loadTasks()
        }
    }

    fun updateTaskState(task: Task) {
        viewModelScope.launch {
            task.id?.let { id ->
                repository.updateTaskState(id, !task.complete)
                loadTasks()
            }
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            task.id?.let { id ->
                repository.deleteTask(id)
                loadTasks()
            }
        }
    }
    //Permisions
    private val _uiState =
        mutableStateOf<MapPermissionState>(MapPermissionState.Requesting)
    val uiState: State<MapPermissionState> = _uiState

    fun onPermissionResult(status: PermissionStatus) {
        _uiState.value = when (status) {
            PermissionStatus.Granted -> MapPermissionState.NavigateToMap
            PermissionStatus.Denied -> MapPermissionState.ShowDenied
            PermissionStatus.PermanentlyDenied -> MapPermissionState.ShowPermanentlyDenied
            PermissionStatus.Unknown -> MapPermissionState.Requesting
        }
    }

}