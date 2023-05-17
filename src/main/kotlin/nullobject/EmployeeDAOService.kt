package nullobject


class EmployeeDAOService {
    private val employees: ArrayList<Employee> = ArrayList()
    init {
        val employee = Employee(1L, "Ambrosio Cardoso",
             Address("Laureles 121 Col. Fresnos"))
        employees.add(employee)
    }

    fun findEmployeeById(id: Long): Employee {
        return employees.firstOrNull { it.getId() == id } ?: Employee.NULL_EMPLOYEE
    }
}