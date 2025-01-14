package com.example.tarokapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _games = MutableStateFlow<List<Game>>(emptyList())
    val games: StateFlow<List<Game>> = _games

    fun fetchGames(profileId: String) {
        viewModelScope.launch {
            try {
                val fetchedGames = ApiClient.apiService.getGamesForProfile(profileId)
                _games.value = fetchedGames
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
