package objectpool

interface IPoolableObjectFactory<T : IPooledObject?> {
    fun createNew(): T
}