package interpreter

import interpreter.Context
import interpreter.InterpreterException

interface SQLExpression {
    @Throws(InterpreterException::class)
    fun interpret(context: Context): Any?
}