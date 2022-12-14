package com.example.formula1.feature_constructor_standing.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.util.Collections.emptyList
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.formula1.feature_constructor_standing.domain.usecase.ConstructorStandingUseCase
import com.example.formula1.ui.util.Formula1State
import com.example.formula1.util.Resource

@HiltViewModel
class ConstructorViewModel @Inject constructor (
    private val constructorStandingUseCase: ConstructorStandingUseCase
) : ViewModel() {

    private val _state = mutableStateOf(Formula1State())
    val state: State<Formula1State> = _state

    private val _isRefresh = MutableStateFlow(false)
    val isRefresh: StateFlow<Boolean> = _isRefresh

    init {
        getConstructorStanding()
    }

    fun refresh() {
        viewModelScope.launch {
            _isRefresh.emit(true)
            getConstructorStanding()
            _isRefresh.emit(false)
        }
    }

    private fun getConstructorStanding() {
        constructorStandingUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = Formula1State(constructor = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = Formula1State(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = Formula1State(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}