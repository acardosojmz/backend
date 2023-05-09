package proxy

class ServiceFactory {
    companion object{
        fun createProcessExecutor(): IProcessExecutor {
            return ProcessExecutorProxy()
        }
    }

}