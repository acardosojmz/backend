package objectpool

class ExecutorTask : IPooledObject {
    private var uses = 0
    fun execute() {
        val c = ++counter
        uses++
        println("execute ==> $c")
        try {
            Thread.sleep(5000)
        } catch (e: Exception) {
        }
        println("execute end ==> $c")
    }

    override fun validate(): Boolean {
        return uses < 2
    }

    override fun invalidate() {
        invalidate++
        println("Invalidate Counter ==> $invalidate")
    }

    companion object {
        private var invalidate = 0
        private var counter = 0
    }
}