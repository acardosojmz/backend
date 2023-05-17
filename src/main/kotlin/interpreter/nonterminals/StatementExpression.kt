package interpreter.nonterminals

import interpreter.Context
import interpreter.InterpreterException
import interpreter.SQLExpression


interface StatementExpression: SQLExpression {
    @Throws(InterpreterException::class)
    override fun interpret(context: Context): Any?

}