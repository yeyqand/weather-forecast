package com.yeyq.weather.core.base

sealed class UiState {
    object Idle : UiState()
    object Pending : UiState()
    object Error : UiState()
}