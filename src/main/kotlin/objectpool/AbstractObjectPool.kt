package objectpool

import java.util.*


abstract class AbstractObjectPool <T : IPooledObject>: IObjectPool<T> {
    private var minInstances = 0
    private var maxInstances = 0
    private var waitTime = 0
    private var poolableObjectFactory: IPoolableObjectFactory<T>? = null
    //private lateinit  var poolableObjectFactory: IPoolableObjectFactory<T>

    private var fullStack = Stack<PooledObjectStatus<T>>()
    private var useStack = Stack<PooledObjectStatus<T>>()
    private var freeStack = Stack<PooledObjectStatus<T>>()
    constructor(
            minInstances: Int,
            maxInstances: Int,
            waitTime: Int,
            poolableObjectFactory: IPoolableObjectFactory<T>?
        ) {
            println("=========== STARTING ============")
            this.minInstances = minInstances
            this.maxInstances = maxInstances
            this.waitTime = waitTime
            this.poolableObjectFactory = poolableObjectFactory
            initPool()
            println("=========== FINISH ============")
            println()
    }

    private fun initPool() {
        for (c in fullStack.size until minInstances) {
            val createNewPooledObject: PooledObjectStatus<T> = createNewPooledObject()
            freeStack.push(createNewPooledObject)
        }
    }

    private class PooledObjectStatus<T>(var pooledObject: T) {
        var used = false
        val uuid: UUID = UUID.randomUUID()

    }

    @Throws(PoolException::class)
    fun getInternalObject(): T? {
        synchronized(freeStack) {
            if (!freeStack.isEmpty()) {
                val first = freeStack.pop()
                first.used = true
                println(
                    "Provisioning1 Object > "
                            + first.uuid.toString()
                )
                useStack.push(first)
                return first.pooledObject
            }
            synchronized(fullStack) {
                return if (fullStack.size < maxInstances) {
                    val returnObject: PooledObjectStatus<T> = createNewPooledObject()
                    returnObject.used = true
                    println(
                        "Provisioning2 Object > "
                                + returnObject.uuid.toString()
                    )
                    useStack.push(returnObject)
                    returnObject.pooledObject
                } else {
                    null
                }
            }
        }
    }

    @Throws(PoolException::class)
    override fun getObject(): T {
        val internalObject = getInternalObject()
        return internalObject ?: waitForResource()
    }

    @Throws(PoolException::class)
    fun waitForResource(): T {
        val future = Calendar.getInstance()
        future.add(Calendar.MILLISECOND, waitTime)
        do {
            var returnObject: PooledObjectStatus<T>? = null
            synchronized(freeStack) {
                if (!freeStack.isEmpty() && !freeStack.peek().used) {
                    returnObject = freeStack.pop()
                    returnObject!!.used = true
                    useStack.push(returnObject)
                    println(
                        "Provisioning3 Object > "
                                + returnObject!!.uuid.toString()
                    )
                    return returnObject!!.pooledObject
                }
            }
            if (returnObject == null || returnObject!!.used) {
                if (waitTime != 0 && System.currentTimeMillis()
                    >= future.timeInMillis
                ) {
                    throw PoolException("Tiempo de espera agotado")
                }
                try {
                    Thread.sleep(1000)
                } catch (e: Exception) {
                }
            }
        } while (true)
    }

    private fun createNewPooledObject(): PooledObjectStatus<T> {
        val newObject: T = poolableObjectFactory!!.createNew()
        val pooled = PooledObjectStatus(newObject)
        fullStack.push(pooled)
        println(
            "New PoolableObject{UUID=" + pooled.uuid.toString() + ", poolSize=" + fullStack.size + "}"
        )
        return pooled
    }

    override fun releaseObject(pooledObject: T) {
        for (item in fullStack) {
            if (item.pooledObject === pooledObject) {
                if (pooledObject.validate()) {
                    freeStack.push(item)
                    useStack.remove(item)
                    item.used = false
                    println(
                        "Object returned > "
                                + item.uuid.toString()
                    )
                    return
                } else {
                    println(
                        "Object Invalidate ==> "
                                + item.uuid.toString()
                    )
                    pooledObject.invalidate()
                    fullStack.remove(item)
                    useStack.remove(item)
                    synchronized(freeStack) { initPool() }
                    return
                }
            }
        }
    }

}