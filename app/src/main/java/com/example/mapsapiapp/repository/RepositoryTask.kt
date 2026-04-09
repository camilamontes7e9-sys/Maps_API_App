package com.example.mapsapiapp.repository

import com.example.mapsapiapp.model.Task
import com.example.mapsapiapp.network.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest

class RepositoryTask {
    private val table = SupabaseClient.client.postgrest["Task"]

    suspend fun addTask(titleP: String, latP: Float, longP: Float, completed: Boolean, descriptionP: String) {
        val newTask = Task(title = titleP, lat = latP, long = longP, complete = completed, description = descriptionP)
        table.insert(newTask)
    }

    suspend fun obtainTasks(): List<Task> {
        return table.select().decodeList<Task>()
    }

    suspend fun updateTaskState(id: Int, completed: Boolean) {
        table.update({
            set("completed", completed)
        }) {
            filter {
                eq("id", id)
            }
        }
    }

    suspend fun deleteTask(id: Int) {
        table.delete {
            filter {
                eq("id", id)
            }
        }
    }
}