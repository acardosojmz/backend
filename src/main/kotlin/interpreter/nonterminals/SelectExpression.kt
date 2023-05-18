package interpreter.nonterminals

import interpreter.Context
import interpreter.SQLExpression

class SelectExpression: SQLExpression {
    private var target: TargetExpression? = null
    private var from: FromExpression? = null
    private var where: WhereExpression? = null
    constructor(
        columns: TargetExpression,
        table: FromExpression)  {
        this.target=columns
        this.from=table
        this.where=WhereExpression(null)
    }
    constructor(
        columns: TargetExpression,
        table: FromExpression,
        where: WhereExpression )  {
        this.target=columns
        this.from=table
        this.where=where
    }

    override fun interpret(context: Context): List<Array<Any?>?>? {
        from!!.interpret(context!!)
        where!!.interpret(context)
        target!!.interpret(context)
        return context.getResultArray()
    }

    override fun toString(): String {
        return "SELECT ${target.toString()}   ${from.toString()}  ${where.toString()}"
    }


}