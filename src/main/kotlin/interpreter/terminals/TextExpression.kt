package interpreter.terminals

import interpreter.Context

class TextExpression(private val literal: String): LiteralExpression(literal) {
    override fun interpret(context: Context): Any {
        return literal
    }

    override fun toString(): String {
        return "'$literal'"
    }
}