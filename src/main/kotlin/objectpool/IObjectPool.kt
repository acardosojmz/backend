package objectpool

interface IObjectPool<T: IPooledObject> {
    @Throws(PoolException::class)
    fun getObject(): T

    fun releaseObject(pooledObject: T)
}