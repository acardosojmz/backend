package interpreter.nonterminals

import interpreter.Context
import interpreter.SQLExpression
import interpreter.terminals.LiteralExpression
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row


class TargetExpression(vararg expressions: LiteralExpression): SQLExpression {
    private var targets: List<LiteralExpression> = ArrayList()
    init {
        targets = expressions.toList()
    }

    override fun interpret(context: Context): Any? {
        context.createResultArray(targets.size)
        val resultRow: List<Row?>? = context.getResultRow()
        if (resultRow != null) {
            for (row in resultRow) {
                val result = context.createRow()
                for ((col, literalExpression) in targets.withIndex()) {
                    val column = literalExpression.interpret(context).toString()
                    context.tableColumn(column)
                    val columnIndex = context.columnIndex(column)
                    val cell: Cell = row!!.getCell(columnIndex)
                    val value = cell.stringCellValue
                    result!![col] = value
                }
            }
        }
        return null
    }

    override fun toString(): String {
        var output = ""
        targets.forEach { output+=it }
        return output.substring(2)
    }
}