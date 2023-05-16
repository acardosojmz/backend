package strategy

import java.security.Principal


class OnMemoryAuthenticationProvider: IAuthenticationStrategy {
    override fun authenticate(userName: String?, password: String?): Credential? {
        val user = OnMemoryDataBase.findUserByName(userName)

        return if  (user != null && user.password == password) {
             Credential(user.password, user.rol)
        } else null
    }

}