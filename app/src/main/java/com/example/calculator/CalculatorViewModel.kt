package com.example.calculator

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.mariuszgromada.math.mxparser.Expression
import kotlin.random.Random

class CalculatorViewModel : ViewModel() {

    private val _state: MutableStateFlow<CalculatorState> = MutableStateFlow(
        CalculatorState.Initial
    )

    val state = _state.asStateFlow()

    private var expression: String = ""

    fun processCommand(command: CalculatorCommand) {
        Log.d("CalculatorViewModel", "Command: $command")

        when (command) {
            CalculatorCommand.Clear -> {
                expression = ""
                _state.value = CalculatorState.Initial
            }

            is CalculatorCommand.Input -> {
                val symbol = if (command.symbol != Symbol.PARENTHESIS) {
                    command.symbol.value
                } else {
                    getCorrectParenthesis()
                }
                expression += symbol

                _state.value = CalculatorState.Input(
                    example = expression, answer = evaluate() ?: ""
                )
            }

            CalculatorCommand.Solution -> {
                val result = evaluate()
                _state.value = if (result != null) {
                    CalculatorState.Success(result)
                } else {
                    CalculatorState.Error(expression)
                }

            }
        }
    }

    private fun evaluate(): String? {
        return expression.replace("x", "*")
            .let { Expression(it) }
            .calculate()
            .takeIf { it.isFinite() } ?.toString()
    }

    fun getCorrectParenthesis(): String {
        val openCount = expression.count { it == '(' }
        val closeCount = expression.count { it == ')' }
        return when {
            expression.isEmpty() -> "("
            !expression.last()
                .isDigit() && expression.last() != ')' && expression.last() != 'π' -> "("

            openCount > closeCount -> ")"
            else -> "("
        }
    }
}

sealed interface CalculatorState {

    data object Initial : CalculatorState
    data class Input(
        val example: String,
        val answer: String,
    ) : CalculatorState

    data class Success(val result: String) : CalculatorState
    data class Error(val example: String) : CalculatorState
}


sealed interface CalculatorCommand {


    data object Clear : CalculatorCommand
    data object Solution : CalculatorCommand
    data class Input(val symbol: Symbol) : CalculatorCommand
}

enum class Symbol(val value: String) {
    DIGIT_0("0"), DIGIT_1("1"), DIGIT_2("2"), DIGIT_3("3"), DIGIT_4("4"), DIGIT_5("5"), DIGIT_6("6"), DIGIT_7(
        "7"
    ),
    DIGIT_8("8"), DIGIT_9("9"), ADD("+"), SUBTRACT("-"), MULTIPLY("x"), DIVIDE("÷"), PERCENT("%"), POWER(
        "^"
    ),
    FACTORIAL("!"), SQRT("√"), PI("π"), DOT("."), PARENTHESIS("()"),
}


data class Display(
    val example: String,
    val answer: String,
)