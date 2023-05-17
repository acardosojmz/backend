package memento

fun main() {
    var option=1
    val exit=0
    val employeeUI= EmployeeUI()
    while (option!=exit){
        println("")
        println("******* MENU ***********")
        println("1-> Agregar ")
        println("2-> Regresar ")
        println("3-> Avanzar ")
        println("0->Salir")
        print("Elija su opción: ")
        option = readln().toInt()
        when(option){
            1->{
                println("")
                print("Numero empleado: ")
                val employeeNumber = readln().toInt()
                print("Nombre: ")
                val name = readln()
                print("Apellidos: ")
                val lastName = readln()
                employeeUI.save(name, lastName,employeeNumber)
            }
            2->{
                employeeUI.previous()
            }
            3->{
                employeeUI.next()
            }
        }
    }
}