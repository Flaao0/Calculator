package com.example.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun Calculator(
    modifier: Modifier = Modifier, viewModel: CalculatorViewModel = viewModel()
) {

    val state = viewModel.state.collectAsState()

    Column(
        Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        bottomEnd = 40.dp, bottomStart = 40.dp, topStart = 0.dp, topEnd = 0.dp
                    )
                )
                .background(MaterialTheme.colorScheme.primaryContainer)
                .weight(1f)
                .padding(bottom = 16.dp, end = 40.dp, start = 40.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            when (val currentState = state.value) {
                is CalculatorState.Error -> {
                    Text(
                        color = MaterialTheme.colorScheme.error,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.SemiBold,
                        text = currentState.expression
                    )
                }

                CalculatorState.Initial -> {}

                is CalculatorState.Input -> {
                    Text(
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.SemiBold,
                        text = currentState.expression
                    )
                    Text(
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold,
                        text = currentState.result
                    )
                }

                is CalculatorState.Success -> {
                    Text(
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.SemiBold,
                        text = currentState.result
                    )
                    Text(
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold,
                        text = ""
                    )
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround
        ) {
            Box(
                modifier = Modifier.clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.SQRT))
                    }) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "√",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }

            Box(
                modifier = Modifier.clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.PI))
                    }) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "π",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }

            Box(
                modifier = Modifier.clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.POWER))
                    }) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "^",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }

            Box(
                modifier = Modifier.clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.FACTORIAL))
                    }) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "!",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary)
                    .weight(1f)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Clear)
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "AC",
                    fontSize = 40.sp,
                )
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .weight(1f)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.PARENTHESIS))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "( )",
                    fontSize = 40.sp,
                )
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .weight(1f)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.PERCENT))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "%",
                    fontSize = 40.sp,
                )
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .weight(1f)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIVIDE))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "÷",
                    fontSize = 40.sp,
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .weight(1f)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_7))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "7",
                    fontSize = 40.sp,
                )
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .weight(1f)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_8))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "8",
                    fontSize = 40.sp,
                )
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .weight(1f)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_9))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "9",
                    fontSize = 40.sp,
                )
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .weight(1f)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.MULTIPLY))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "X",
                    fontSize = 40.sp,
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .weight(1f)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_4))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "4",
                    fontSize = 40.sp,
                )
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .weight(1f)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_5))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "5",
                    fontSize = 40.sp,
                )
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .weight(1f)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_6))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "6",
                    fontSize = 40.sp,
                )
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .weight(1f)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.SUBTRACT))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "-",
                    fontSize = 40.sp,
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .weight(1f)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_1))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "1",
                    fontSize = 40.sp,
                )
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .weight(1f)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_2))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "2",
                    fontSize = 40.sp,
                )
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .weight(1f)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_3))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "3",
                    fontSize = 40.sp,
                )
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .weight(1f)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.ADD))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "+",
                    fontSize = 40.sp,
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .weight(2f)
                    .aspectRatio(2f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_0))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "0",
                    fontSize = 40.sp,
                )
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .weight(1f)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DOT))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = ",",
                    fontSize = 40.sp,
                )
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .weight(1f)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Evaluate)
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "=",
                    fontSize = 40.sp,
                )
            }
        }
    }

}

@Preview
@Composable
private fun ComposablePreview() {
    CalculatorTheme() {
        Calculator()
    }
}