package objectpool

interface IPooledObject {
    fun validate(): Boolean
    fun invalidate()
}