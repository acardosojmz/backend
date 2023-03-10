package objectpool

class ExecutorTaskFactory : IPoolableObjectFactory<ExecutorTask?> {
    override fun createNew(): ExecutorTask {
        return ExecutorTask()
    }
}