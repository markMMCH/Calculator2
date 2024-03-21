package com.example.calculator2

data class CalculatorState(
    val operationsStack: List<Char> = mutableListOf(),
    val operandsStack: List<String> = mutableListOf(),
    val expression: String = "",
    val result: Double = 0.0
) {

}