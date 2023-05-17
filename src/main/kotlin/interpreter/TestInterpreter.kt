package interpreter

import interpreter.nonterminals.SelectExpression
import java.text.SimpleDateFormat
import java.util.*
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.getById


fun main(){
    val select: SelectExpression? = InterpreterMain.getById()
    println(select.toString())
    val context = Context("interpreter/Employees.xls")
    context.setDateFormat(SimpleDateFormat("dd/MM/yyyy"))
    try {
        val output = select!!.interpret(context)
        for (`object` in output!!) {
            println(Arrays.toString(`object`))
        }
    } catch (e: InterpreterException) {
        e.printStackTrace()
    } finally {
        context.destroy()
    }
}