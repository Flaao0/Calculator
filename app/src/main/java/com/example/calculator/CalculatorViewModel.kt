package com.example.calculator

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random


class CalculatorViewModel: ViewModel() {

    val _state: MutableStateFlow<CalculatorState> = MutableStateFlow(
        CalculatorState.Initial
    )
    val state
        get() = _state.asStateFlow()

    fun processCommand(command: CalculatorCommand) {
        when (command) {
            CalculatorCommand.Clear -> {
                _state.value = CalculatorState.Initial
            }
            CalculatorCommand.Evaluate -> {
                val isError = Random.nextBoolean()
                if (isError) {
                    _state.value = CalculatorState.Error("777")
                } else {
                    _state.value = CalculatorState.Success("111")
                }
                Log.d("CalculatorViewModel", "Evaluate")
            }

            is CalculatorCommand.Input -> {
                _state.value = CalculatorState.Input(
                    expression = command.symbol.name,
                    result = "123"
                )
                Log.d("CalculatorViewModel", "$command")
            }
        }
    }
}

sealed interface CalculatorState {

    data object Initial: CalculatorState

    data class Input(
        val expression: String,
        val result: String
    ): CalculatorState

    data class Success(val result: String): CalculatorState

    data class Error(val expression: String): CalculatorState
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