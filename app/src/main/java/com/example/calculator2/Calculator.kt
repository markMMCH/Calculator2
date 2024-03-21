package com.example.calculator2
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Calculator(
    state: CalculatorState,
    onAction: (CalculatorUIEvents) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.LightGray).padding(5.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = state.expression,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 70.dp).height(70.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 60.sp,
            color = Color.Black,
            maxLines = 3,

        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            CalculatorButton(
                label = "AC",
                modifier = Modifier
                    .background(Color(0xFF2E2E2E))
                    .aspectRatio(2f)
                    .weight(2f),
                onclick = {
                    onAction(CalculatorUIEvents.AllClear)
                }
            )
            CalculatorButton(
                label = "C",
                modifier = Modifier
                    .background(Color(0xFF2E2E2E))
                    .aspectRatio(1f)
                    .weight(1f),
                onclick = {
                    onAction(CalculatorUIEvents.Delete)
                }
            )

            CalculatorButton(
                label = "/",
                modifier = Modifier
                    .background(Color(0xFFFF9800))
                    .aspectRatio(1f)
                    .weight(1f),
                onclick = {
                    onAction(CalculatorUIEvents.OperationAdded('/'))
                }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            CalculatorButton(
                label = "7", modifier = Modifier
                    .background(Color.Gray)
                    .aspectRatio(1f)
                    .weight(1f),
                onclick = {
                    onAction(CalculatorUIEvents.OperandAdded('7'))
                }
            )
            CalculatorButton(
                label = "8", modifier = Modifier
                    .background(Color.Gray)
                    .aspectRatio(1f)
                    .weight(1f),
                onclick = {
                    onAction(CalculatorUIEvents.OperandAdded('8'))
                }
            )
            CalculatorButton(
                label = "9", modifier = Modifier
                    .background(Color.Gray)
                    .aspectRatio(1f)
                    .weight(1f),
                onclick = {
                    onAction(CalculatorUIEvents.OperandAdded('9'))
                }
            )
            CalculatorButton(
                label = "*", modifier = Modifier
                    .background(Color(0xFFFF9800))
                    .aspectRatio(1f)
                    .weight(1f),
                onclick = {
                    onAction(CalculatorUIEvents.OperationAdded('*'))
                }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            CalculatorButton(
                label = "4", modifier = Modifier
                    .background(Color.Gray)
                    .aspectRatio(1f)
                    .weight(1f),
                onclick = {
                    onAction(CalculatorUIEvents.OperandAdded('4'))
                }
            )
            CalculatorButton(
                label = "5", modifier = Modifier
                    .background(Color.Gray)
                    .aspectRatio(1f)
                    .weight(1f),
                onclick = {
                    onAction(CalculatorUIEvents.OperandAdded('5'))
                }
            )
            CalculatorButton(
                label = "6", modifier = Modifier
                    .background(Color.Gray)
                    .aspectRatio(1f)
                    .weight(1f),
                onclick = {
                    onAction(CalculatorUIEvents.OperandAdded('6'))
                }
            )
            CalculatorButton(
                label = "-", modifier = Modifier
                    .background(Color(0xFFFF9800))
                    .aspectRatio(1f)
                    .weight(1f),
                onclick = {
                    onAction(CalculatorUIEvents.OperationAdded('-'))
                }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            CalculatorButton(
                label = "1", modifier = Modifier
                    .background(Color.Gray)
                    .aspectRatio(1f)
                    .weight(1f),
                onclick = {
                    onAction(CalculatorUIEvents.OperandAdded('1'))
                }
            )
            CalculatorButton(
                label = "2", modifier = Modifier
                    .background(Color.Gray)
                    .aspectRatio(1f)
                    .weight(1f),
                onclick = {
                    onAction(CalculatorUIEvents.OperandAdded('2'))
                }
            )
            CalculatorButton(
                label = "3", modifier = Modifier
                    .background(Color.Gray)
                    .aspectRatio(1f)
                    .weight(1f),
                onclick = {
                    onAction(CalculatorUIEvents.OperandAdded('3'))
                }
            )
            CalculatorButton(
                label = "+", modifier = Modifier
                    .background(Color(0xFFFF9800))
                    .aspectRatio(1f)
                    .weight(1f),
                onclick = {
                    onAction(CalculatorUIEvents.OperationAdded('+'))
                }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            CalculatorButton(
                label = "0", modifier = Modifier
                    .background(Color.Gray)
                    .aspectRatio(1f)
                    .weight(1f),
                onclick = {
                    onAction(CalculatorUIEvents.OperandAdded('0'))
                }
            )

            CalculatorButton(
                label = "(", modifier = Modifier
                    .background(Color.Gray)
                    .aspectRatio(1f)
                    .weight(1f),
                onclick = {
                    onAction(CalculatorUIEvents.OperationAdded('('))
                }
            )
            CalculatorButton(
                label = ")", modifier = Modifier
                    .background(Color.Gray)
                    .aspectRatio(1f)
                    .weight(1f),
                onclick = {
                    onAction(CalculatorUIEvents.OperationAdded(')'))
                }
            )
            CalculatorButton(
                label = "=", modifier = Modifier
                    .background(Color(0xFFFF9800))
                    .aspectRatio(1f)
                    .weight(1f),
                onclick = {
                    onAction(CalculatorUIEvents.Calculate)
                }
            )

        }
    }
}