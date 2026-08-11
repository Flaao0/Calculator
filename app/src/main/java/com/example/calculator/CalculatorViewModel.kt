package com.example.calculator

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class CalculatorViewModel: ViewModel() {

    val _state = MutableStateFlow(
        Display(
            example = "1488x67",
            result = "322"
        )
    )
    val state
        get() = _state.asStateFlow()

    fun processCommand(command: CalculatorCommand) {
        when (command) {
            CalculatorCommand.Clear -> {
                _state.value = Display("", "")
                Log.d("CalculatorViewModel", "Clear")
            }
            CalculatorCommand.Evaluate -> {
                Log.d("CalculatorViewModel", "Evaluate")
            }

            is CalculatorCommand.Input -> {
                Log.d("CalculatorViewModel", "$command")
            }
        }
    }
}

sealed interface CalculatorCommand {

    data object Clear: CalculatorCommand
    data object Evaluate: CalculatorCommand
    data class Input(val symbol: Symbol): CalculatorCommand
}

enum class Symbol {
    DIGIT_0,
    DIGIT_1,
    DIGIT_2,
    DIGIT_3,
    DIGIT_4,
    DIGIT_5,
    DIGIT_6,
    DIGIT_7,
    DIGIT_8,
    DIGIT_9,
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE,
    PERCENT,
    POWER,
    FACTORIAL,
    SQRT,
    PI,
    DOT,
    PARENTHESIS
}

data class Display(
    val example: String,
    val result: String
)