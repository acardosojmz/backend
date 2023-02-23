package abstractfactory

class EmployeeServiceWSImpl:IEmployeeService {
    private val employees = listOf("SOA-Maria", "SOA-Rosalia", "SOA-Liliana")
    override fun getEmployee(): List<String> {
        return this.employees
    }
}