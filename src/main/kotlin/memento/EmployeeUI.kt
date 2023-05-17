package memento

import java.awt.event.ActionEvent


class EmployeeUI {
    private var employee = Employee("-------","----------",0)
    private val caretaker = EmployeeCaretaker()

    fun save(name: String, lastName: String, employeeNumber: Int){
        employee.name=name
        employee.lastName= lastName
        employee.employeeNumber= employeeNumber
        caretaker.addNewMemento(employee.createMemento())
    }

    fun previous() {
        val memento = caretaker.getPreviousMemento()
        if (memento == null) {
            println("\nNo existen más estados")
            return
        }
        employee.restoreMemento(memento)
        updateModel()
    }
    fun next() {
        val memento = caretaker.getNextMemento()
        if (memento == null) {
            println("\nNo existen más estados")
            return
        }
        employee.restoreMemento(memento)
        updateModel()
    }
    private fun updateModel() {
        println("*************Empleado Recuperado*****************")
        println("${employee.employeeNumber}, ${employee.name}, ${employee.lastName}")
        println("*************************************************")
        readln()
    }
}