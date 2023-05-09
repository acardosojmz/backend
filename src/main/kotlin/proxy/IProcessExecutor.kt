package proxy

interface IProcessExecutor {
    @Throws(Exception::class)
    fun executeProcess(idProcess: Int, user: String, password: String)
}