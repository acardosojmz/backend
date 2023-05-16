package strategy

import java.security.Principal




interface IAuthenticationStrategy {
    fun authenticate(userName: String?, password: String?): Credential?
}