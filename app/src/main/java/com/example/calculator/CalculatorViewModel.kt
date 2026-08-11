package com.example.calculator

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {

    val state = mutableStateOf(
        Display(
            example = "1488x67",
            result = "322"
        )
    )

    fun processCommand(command: String) {
        when (command) {
            "AC" -> {
                state.value = Display("", "")
            }
            "1" -> {
                state.value = Display("1", "")
            }
            "2" -> {
                state.value = Display("", "2")
            }
        }
    }
}

data class Display(
    val example: String,
    val result: String
)