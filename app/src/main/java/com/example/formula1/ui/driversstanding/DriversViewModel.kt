package com.example.formula1.ui.driversstanding

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.formula1.domain.usecases.DriversStandingUseCase
import com.example.formula1.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DriversViewModel @Inject constructor(
    private val driversStandingUseCase: DriversStandingUseCase
) : ViewModel() {

    private val _state = mutableStateOf(DriverListState())
    val state: State<DriverListState> = _state

    init {
        getDriversStandings()
    }

    private fun getDriversStandings() {
        driversStandingUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = DriverListState(drivers = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = DriverListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = DriverListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}