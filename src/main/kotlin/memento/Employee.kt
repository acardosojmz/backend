package memento

data class Employee(
    var name: String,
    var lastName: String,
    var employeeNumber: Int
    ): Cloneable {
        fun createMemento(): EmployeeMemento{
            return EmployeeMemento(this.clone() as Employee)
        }
    fun restoreMemento(memento: EmployeeMemento) {
        val (name, lastName, employeeNumber) = memento.employee
        this.name = name
        this.lastName = lastName
        this.employeeNumber = employeeNumber
    }
}
