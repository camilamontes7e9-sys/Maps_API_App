package com.example.mapsapiapp.repository

class RepositoryTask {
    // Apuntem directament a la taula "tasques"
    private val taula = SupabaseClient.client.postgrest["tasques"]

    suspend fun afegirTasca(titol: String) {
        val novaTasca = Tasca(titol = titol)
        taula.insert(novaTasca)
    }

    suspend fun obtenirTasques(): List<Tasca> {
        return taula.select().decodeList<Tasca>()
    }

    suspend fun actualitzarEstatTasca(id: String, completada: Boolean) {
        taula.update({
            set("completada", completada)
        }) {
            filter {
                eq("id", id)
            }
        }
    }

    suspend fun esborrarTasca(id: String) {
        taula.delete {
            filter {
                eq("id", id)
            }
        }
    }
}