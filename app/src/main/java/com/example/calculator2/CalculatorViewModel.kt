package com.example.calculator2
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorUIEvents) {
        when (action) {
            is CalculatorUIEvents.OperandAdded -> operandAdded(action.operand)
            is CalculatorUIEvents.OperationAdded -> operationAdded(action.operation)
            is CalculatorUIEvents.AllClear -> state = CalculatorState()
            is CalculatorUIEvents.Delete -> delete()
            is CalculatorUIEvents.Calculate -> calculate()
        }
    }

    private fun operandAdded(operand: Char) {
        state = state.copy(
            expression = state.expression + operand
        )
    }

    private fun operationAdded(operation: Char) {
        state = state.copy(
            expression = state.expression + operation
        )
    }

    private fun delete() {
        state = state.copy(
            expression = state.expression.substring(0, state.expression.length - 1)
        )
    }

    private fun calculate() {
        var i = 0
        while (i < state.expression.length) {
            if (state.expression[i] == '(') {
                state = state.copy(
                    operationsStack = state.operationsStack + '('
                )
            } else if (state.expression[i].isDigit()) {
                var wholeNumber = 0
                while ((i < state.expression.length) &&
                    state.expression[i].isDigit()
                ) {
                    wholeNumber = wholeNumber * 10 + (state.expression[i] - '0')
                    ++i
                }
                state = state.copy(
                    operandsStack = state.operandsStack + wholeNumber.toString()
                )
                i--
            } else if (state.expression[i] == ')') {
                while (state.operationsStack.isNotEmpty() && state.operationsStack.last() != '(') {
                    doLastOperation()
                }
                if (state.operationsStack.isNotEmpty()) {
                    state = state.copy(
                        operationsStack = state.operationsStack.dropLast(1)
                    )
                }
            } else {
                while (state.operationsStack.isNotEmpty() && precedence(state.operationsStack.last()) >= precedence(
                        state.expression[i]
                    )
                ) {
                    doLastOperation()
                }
                state = state.copy(
                    operationsStack = state.operationsStack + state.expression[i]
                )
            }
            ++i
        }
        while (state.operationsStack.isNotEmpty()) {
            doLastOperation()
        }
        state = state.copy(
            expression = state.operandsStack.first()
        )
    }


    private fun precedence(op: Char): Int {
        if (op == '*' || op == '/') return 2 else if (op == '+' || op == '-') return 1
        return 0
    }

    private fun operation(a: Double, op: Char, b: Double): Double {
        if (op == '+') {
            return a + b
        } else if (op == '-') {
            return a - b
        } else if (op == '*') {
            return a * b
        }
        return a / b
    }

    private fun doLastOperation() {
        val lastNumber = state.operandsStack.last().toDouble()
        state = state.copy(
            operandsStack = state.operandsStack.dropLast(1)
        )
        val secondToLastNumber = state.operandsStack.last().toDouble()
        state = state.copy(
            operandsStack = state.operandsStack.dropLast(1)
        )
        val operator = state.operationsStack.last()
        state = state.copy(
            operationsStack = state.operationsStack.dropLast(1)
        )
        state = state.copy(
            operandsStack = state.operandsStack +
                    operation(
                        secondToLastNumber,
                        operator,
                        lastNumber
                    ).toString()
        )
    }
}