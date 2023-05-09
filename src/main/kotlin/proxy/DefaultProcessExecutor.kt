package proxy

class DefaultProcessExecutor : IProcessExecutor {
    override fun executeProcess(idProcess: Int, user: String, password: String) {
        println("Process $idProcess in execution")
        println("Process $idProcess finished")
    }
}