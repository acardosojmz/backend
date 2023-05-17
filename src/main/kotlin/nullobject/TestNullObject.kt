package nullobject

fun main() {
    val employeeDAOService = EmployeeDAOService()
    val employee1 = employeeDAOService.findEmployeeById(1L)
    println(employee1.getName() +"\t" + employee1.getAddress().getFullAddress())
    val employee2 = employeeDAOService.findEmployeeById(2L)
    println(employee2.getName() +"\t" +  employee2.getAddress().getFullAddress())
}