package com.example.mapsapiapp.viewModel

import androidx.lifecycle.ViewModel

class MapsViewModel: ViewModel() {
    private val repository = TascaRepository()

    private val _tasques = MutableStateFlow<List<Tasca>>(emptyList())
    val tasques: StateFlow<List<Tasca>> = _tasques

    init {
        carregarTasques()
    }

    private fun carregarTasques() {
        viewModelScope.launch {
            try {
                _tasques.value = repository.obtenirTasques()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun afegirTasca(titol: String) {
        viewModelScope.launch {
            repository.afegirTasca(titol)
            carregarTasques()
        }
    }

    fun canviarEstatTasca(tasca: Tasca) {
        viewModelScope.launch {
            tasca.id?.let { id ->
                repository.actualitzarEstatTasca(id, !tasca.completada)
                carregarTasques()
            }
        }
    }

    fun esborrarTasca(tasca: Tasca) {
        viewModelScope.launch {
            tasca.id?.let { id ->
                repository.esborrarTasca(id)
                carregarTasques()
            }
        }
    }
}