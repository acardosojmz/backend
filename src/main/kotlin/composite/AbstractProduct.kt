package composite

abstract class AbstractProduct (val name: String, private val price:Double) {
    open fun getPrice() = price
}