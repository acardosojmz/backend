package interpreter.terminals

import interpreter.Context
import interpreter.SQLExpression

open class LiteralExpression(private var literal: String): SQLExpression {
    override fun interpret(context: Context): Any {
        return literal
    }

    override fun toString(): String {
        return literal
    }
}