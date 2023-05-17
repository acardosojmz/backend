package interpreter.nonterminals

import interpreter.Context


class AndExpression(private val leftStatement: StatementExpression?,
    private val rightStatement: StatementExpression?): StatementExpression {

    override fun interpret(context: Context): Any? {
        val leftResult = leftStatement!!.interpret(context) as Boolean?
        val rightResult = rightStatement!!.interpret(context) as Boolean?
        return leftResult!! && rightResult!!
    }

    override fun toString(): String {
        return "( ${leftStatement.toString()} AND ${rightStatement.toString()}  )"
    }

}