package interpreter.nonterminals

import interpreter.Context
import interpreter.InterpreterException
import interpreter.SQLExpression
import interpreter.terminals.LiteralExpression


class FromExpression(private val table: LiteralExpression): SQLExpression {


    override fun interpret(context: Context): Any? {
        val tableName: String = table.interpret(context).toString()
        if (!context.tableExist(tableName)) {
            throw InterpreterException(
                "La tabla '$tableName' no existe"
            )
        }
        return null
    }

    override fun toString(): String {
        return  " FROM ${table.toString()} "
    }
}