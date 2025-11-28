package com.example.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview
@Composable
fun CalculatorPreview() {
    CalculatorTheme {
        Calculator()
    }
}

@Composable
fun Calculator(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel = viewModel(),
) {
    val state = viewModel.state.collectAsState()

    Column(
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clip(RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp))
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(bottom = 16.dp, end = 40.dp, start = 40.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            val currentState = state.value

            when (currentState) {
                is CalculatorState.Error -> {
                    Text(
                        text = currentState.example, lineHeight = 36.sp, style = TextStyle(
                            fontSize = 36.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.error
                        )
                    )
                    Text(
                        text = "", lineHeight = 36.sp, style = TextStyle(
                            fontSize = 17.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    )
                }

                CalculatorState.Initial -> {}
                is CalculatorState.Input -> {
                    Text(
                        text = currentState.example, lineHeight = 36.sp, style = TextStyle(
                            fontSize = 36.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                        )
                    )
                    Text(
                        text = currentState.answer, style = TextStyle(
                            fontSize = 17.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    )
                }

                is CalculatorState.Success -> {
                    Text(
                        text = currentState.result, lineHeight = 36.sp, style = TextStyle(
                            fontSize = 36.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    )
                    Text(
                        text = "", lineHeight = 17.sp, style = TextStyle(
                            fontSize = 17.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    )
                }
            }
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 24.dp),
        ) {

            Text(
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.SQRT))
                    }, text = "√", style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )


            Text(
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.PI))
                    }, text = "π", style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )


            Text(
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.POWER))
                    }, text = "^", style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )


            Text(
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.FACTORIAL))
                    }, text = "!", style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )

        }

        Row(
            modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Clear)
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "AC", style = TextStyle(
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.PARENTHESIS))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "(  )", style = TextStyle(
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.PERCENT))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "%", style = TextStyle(
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIVIDE))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "÷", style = TextStyle(
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                )
            }
        }


        Row(
            modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_7))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "7", style = TextStyle(
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_8))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "8", style = TextStyle(
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_9))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "9", style = TextStyle(
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.MULTIPLY))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "X", style = TextStyle(
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                )
            }
        }


        Row(
            modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_4))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "4", style = TextStyle(
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_5))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "5", style = TextStyle(
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_6))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "6", style = TextStyle(
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.SUBTRACT))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "-", style = TextStyle(
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                )
            }
        }

        Row(
            modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_1))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "1", style = TextStyle(
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_2))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "2", style = TextStyle(
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_3))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "3", style = TextStyle(
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.ADD))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "+", style = TextStyle(
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                )
            }
        }


        Row(
            modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(2f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .aspectRatio(2f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_0))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "0", style = TextStyle(
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                )
            }


            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DOT))
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = ",", style = TextStyle(
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Solution)
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "=", style = TextStyle(
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                )
            }
        }


    }

}



