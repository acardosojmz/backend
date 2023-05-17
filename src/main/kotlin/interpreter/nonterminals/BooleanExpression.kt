package interpreter.nonterminals

import interpreter.Context
import interpreter.InterpreterException
import interpreter.terminals.DateExpression
import interpreter.terminals.LiteralExpression
import interpreter.terminals.NumericExpression
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import java.util.*


class BooleanExpression: StatementExpression {
    private var leftExpression: LiteralExpression? = null
    private var booleanOperator: LiteralExpression? = null
    private var rightExpression: LiteralExpression? = null



    constructor(
        leftExp: LiteralExpression?,
        operator: LiteralExpression?, rightExp: LiteralExpression?
    ) {
        leftExpression = leftExp
        booleanOperator = operator
        rightExpression = rightExp
    }

    override fun interpret(context: Context): Any? {
        val currentRow: Row? = context.getCurrentRow()
        val left = leftExpression!!.interpret(context).toString()
        val opr = booleanOperator!!.interpret(context).toString()
        val right = rightExpression!!.interpret(context)
        val columnIndex = context.columnIndex(left)
        val cell: Cell = currentRow!!.getCell(columnIndex)
        return if (rightExpression is NumericExpression) {
            val cellValue = cell.numericCellValue
            val rightVal = (right as Number).toDouble()
            if (opr == "=") {
                cellValue == rightVal
            } else if (opr == "<>" || opr == "!=") {
                cellValue != rightVal
            } else if (opr == ">") {
                cellValue > rightVal
            } else if (opr == ">=") {
                cellValue >= rightVal
            } else if (opr == "<") {
                cellValue < rightVal
            } else if (opr == "<=") {
                cellValue <= rightVal
            } else {
                throw RuntimeException(
                    "Operador no esperado '$opr'"
                )
            }
        } else if (rightExpression is DateExpression) {
            val cellValue = cell.stringCellValue
            var cellDateLong: Long = 0
            val expressionDateLong: Long = (right as Date).time
            cellDateLong = try {
                val date: Date = context.getDateFormat()!!.parse(cellValue)
                date.time
            } catch (e: Exception) {
                throw InterpreterException(
                    "Fecha inválida > $cellValue"
                )
            }
            if (opr == "=") {
                cellDateLong == expressionDateLong
            } else if (opr == "<>" || opr == "!=") {
                cellDateLong != expressionDateLong
            } else if (opr == ">") {
                cellDateLong > expressionDateLong
            } else if (opr == ">=") {
                cellDateLong >= expressionDateLong
            } else if (opr == "<") {
                cellDateLong < expressionDateLong
            } else if (opr == "<=") {
                cellDateLong <= expressionDateLong
            } else {
                throw RuntimeException(
                    "Operador no esperado '$opr'"
                )
            }
        } else if (rightExpression is LiteralExpression)
         {

            val cellValue = cell.stringCellValue
            val rightVal = right.toString()
            if (opr == "=") {
                cellValue == rightVal
            } else if (opr == "<>" || opr == "!=") {
                !cellValue.equals(rightVal, ignoreCase = true)
            } else if (opr == ">") {
                val result = cellValue.toString().compareTo(rightVal, ignoreCase = true)
                result > 0
            } else if (opr == ">=") {
                val result = cellValue.toString().compareTo(rightVal, ignoreCase = true)
                result >= 0
            } else if (opr == "<") {
                val result = cellValue.toString().compareTo(rightVal, ignoreCase = true)
                result < 0
            } else if (opr == "<=") {
                val result = cellValue.toString().compareTo(rightVal, ignoreCase = true)
                result <= 0
            } else {
                throw RuntimeException(
                    "Operador no esperado '$opr'"
                )
            }
        } else {
            throw RuntimeException(
                "Tipo de celda no soportada "
                        + right.javaClass.simpleName
            )
        }

    }

    override fun toString(): String {
        return "${leftExpression.toString()}    ${booleanOperator.toString()}    ${rightExpression.toString()}"
    }
}