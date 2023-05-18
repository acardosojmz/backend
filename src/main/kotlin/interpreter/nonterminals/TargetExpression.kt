package interpreter.nonterminals

import interpreter.Context
import interpreter.SQLExpression
import interpreter.terminals.LiteralExpression
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.Row
import kotlin.reflect.typeOf


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
                    val cell= row!!.getCell(columnIndex)
                    var value: Any=""
                    if (cell.cellType==CellType.STRING ){
                        value=  cell.stringCellValue
                    }else if (cell.cellType==CellType.NUMERIC){
                        value = cell.numericCellValue.toString()
                    } else if (cell.cellType==CellType.BOOLEAN){
                        value = cell.booleanCellValue
                    }

                    result!![col] = value
                }
            }
        }
        return null
    }

    override fun toString(): String {
        var output = ""
        targets.forEach { output+= "$it," }
        return output.substring(0,output.length-1)
    }
}