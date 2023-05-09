package proxy

class SecurityService {
    fun authorization(user: String, password: String): Boolean {
        return if (user == "acardosojmz" && password == "t0ps3cr3t") {
            println("Usuario $user autorizado")
            true
        } else {
            println("Usuario $user NO autorizado")
            false
        }
    }
}