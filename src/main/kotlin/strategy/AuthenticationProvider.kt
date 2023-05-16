package strategy

class AuthenticationProvider(private val strategy: IAuthenticationStrategy) {
    fun authenticate (userName: String?, password: String?): Credential? {
        return strategy.authenticate(userName, password)
    }
}