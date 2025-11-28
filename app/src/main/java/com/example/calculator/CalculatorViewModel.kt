package com.example.calculator

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CalculatorViewModel: ViewModel() {

    private val _state = MutableStateFlow(
        Display(
            "45x8",
            "360"
        )
    )

    val state: StateFlow<Display>
        get() = _state.asStateFlow()

    fun processCommand(command: CalculatorCommand) {
        Log.d("CalculatorViewModel", "Command: $command")

        when (command) {
            CalculatorCommand.Clear -> {
                _state.value = Display("", "")
            }
            is CalculatorCommand.Input -> {

            }
            CalculatorCommand.Solution -> {

            }
        }
    }
}


sealed interface CalculatorCommand {


    data object Clear: CalculatorCommand
    data object Solution: CalculatorCommand
    data class Input(val symbol: Symbol): CalculatorCommand
}

enum class Symbol() {
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
    val answer: String
)