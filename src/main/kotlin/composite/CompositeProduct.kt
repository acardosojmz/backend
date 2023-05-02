package composite


class CompositeProduct (name: String): AbstractProduct(name,0.0) {
    private val products: MutableList<AbstractProduct> = ArrayList()

    fun addProduct(product: AbstractProduct) {
        products.add (product)
    }

    fun removeProduct(product: AbstractProduct): Boolean {
        return products.remove(product)
    }

    override fun getPrice(): Double {
        return products.sumOf {it.getPrice() }
    }

}