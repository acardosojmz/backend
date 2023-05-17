package interpreter.terminals

import interpreter.Context

class NumericExpression(private val number: Number): LiteralExpression("") {
    override fun interpret(context: Context): Any {
        return number
    }

    override fun toString(): String {
        return number.toString()
    }
}