package com.example.kotlin56.utils

data class UiState<T>(
    val isLoading:Boolean = true,
    val errorMessage: String? = null,
    val succes: T? = null
    )

