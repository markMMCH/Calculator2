package com.example.calculator2

sealed class CalculatorUIEvents {
    data class OperandAdded(val operand: Char) : CalculatorUIEvents()
    data class OperationAdded(val operation: Char) : CalculatorUIEvents()
    data object Delete: CalculatorUIEvents()
    data object AllClear: CalculatorUIEvents()
    data object Calculate: CalculatorUIEvents()
}