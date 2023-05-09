package proxy

class ProcessExecutorProxy: IProcessExecutor {
    override fun executeProcess(idProcess: Int, user: String, password: String) {
        val securityService = SecurityService()

        if(!securityService.authorization(user, password)){
            throw Exception("The user $user not have privileges for execute process")
        }
        val executorProcess =  DefaultProcessExecutor()
        executorProcess.executeProcess(idProcess, user, password)
        val audit = AuditService()
        audit.auditServiceUsed(user, DefaultProcessExecutor::class.java.name)
    }
}