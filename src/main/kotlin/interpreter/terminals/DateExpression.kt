package interpreter.terminals

import interpreter.Context
import interpreter.InterpreterException


class DateExpression(private val literal: String): LiteralExpression(literal) {
    override fun interpret(context: Context): Any {
        return try {
            val dateFormat = context.getDateFormat()
            dateFormat!!.parse(literal)
        } catch (e: Exception) {
            throw InterpreterException("Formato de fecha inválido '$literal'")
        }
    }

    override fun toString(): String {
        return "'$literal'"
    }
}