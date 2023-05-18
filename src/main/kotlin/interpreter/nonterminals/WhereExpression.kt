package interpreter.nonterminals

import interpreter.Context
import interpreter.SQLExpression

class WhereExpression(private val statement: StatementExpression?): SQLExpression {
    override fun interpret(context: Context): Any? {
        context.createRowIterator()
        while (context.nextRow()) {
            if (statement == null) {
                context.addCurrentRowToResults()
            } else {
                if (statement.interpret(context) as Boolean) {
                    context.addCurrentRowToResults()
                }
            }
        }
        return null
    }

    override fun toString(): String {
        if (statement != null) {
            return " WHERE $statement "
        } else {
            return "";
        }
    }
}