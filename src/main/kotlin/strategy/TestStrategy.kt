package strategy

fun main(){
    println("Usuario: ")
    val userName = readlnOrNull()
    println("password: ")
    val password = readlnOrNull()

    println("Introduzca el tipo de autenticación a utlizar ")
    println("1->OnMemory")
    println("2->SQL")
    println("3->XML\n")
    val option= readlnOrNull()


    when (option!!.toInt()){
        1-> {
            val authOnMemory = AuthenticationProvider(OnMemoryAuthenticationProvider())
            val credential = authOnMemory.authenticate(userName, password)

            if (credential != null) {
                println("Autenticación exitosa en onMemoryAuthentication")
            } else {
                println("Credenciales no válidas")
            }
        }
        2->{
            val authOnDB = AuthenticationProvider(SQLAuthenticationProvider())
            val credential = authOnDB.authenticate(userName, password)

            if (credential != null) {
                println("Autenticación exitosa en SQLAuthentication")
            }else {
                println("Credenciales no válidas")
            }
        }
        3->{
            val authOnXML = AuthenticationProvider(XMLAuthenticationProvider())
            val credential = authOnXML.authenticate(userName, password)

            if (credential != null) {
                println("Autenticación exitosa en XMLAuthentication")
            }else {
                println("Credenciales no válidas")
            }
        }
    }

}