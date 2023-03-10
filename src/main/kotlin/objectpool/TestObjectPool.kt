package objectpool


fun main() {
    val pool = ExecutorThreadPool(2, 6, 1000 * 100, ExecutorTaskFactory() as IPoolableObjectFactory<ExecutorTask>)
    for (c in 0..9) {
        Thread {
            try {
                val task: ExecutorTask = pool.getObject()
                task.execute()
                pool.releaseObject(task)
            } catch (e: PoolException) {
                println("Error ==> " + e.message)
                e.printStackTrace()
            }
        }.start()
    }
    try {
        System.`in`.read()
        println(pool)
    } catch (e: Exception) {
        println("Out disponible")
    }
}