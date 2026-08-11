package com.example.calculator

import android.util.Log
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme

val viewModel = CalculatorViewModel()

@Composable
fun Calculator(
    modifier: Modifier = Modifier
) {

    val state = viewModel.state

    Column(
        Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        bottomEnd = 40.dp,
                        bottomStart = 40.dp,
                        topStart = 0.dp,
                        topEnd = 0.dp
                    )
                )
                .background(MaterialTheme.colorScheme.primaryContainer)
                .weight(1f)
                .padding(bottom = 16.dp, end = 40.dp, start = 40.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Text(
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontSize = 36.sp,
                fontWeight = FontWeight.SemiBold,
                text = state.value.example
            )
            Text(
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold,
                text = state.value.result
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Box {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "√",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }

            Box{
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "π",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }

            Box{
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "^",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }

            Box{
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
                        viewModel.processCommand("AC")
                    },
                contentAlignment = Alignment.Center
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
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
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
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
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
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
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
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
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
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
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
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
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
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
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
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
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
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
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
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
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
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
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
                        viewModel.processCommand("1")
                    },
                contentAlignment = Alignment.Center
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
                        viewModel.processCommand("2")
                    },
                contentAlignment = Alignment.Center
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
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
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
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
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
                    .aspectRatio(2f),
                contentAlignment = Alignment.Center
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
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
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
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
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