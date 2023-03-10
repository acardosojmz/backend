package prototype

data class ProductItem(val name:String?, var price: Double=0.0):
    IPrototype<ProductItem> {
    override fun clone(): Any {
        return ProductItem(name, price)
    }
    override fun deepClone(): ProductItem {
        return (this.clone() as ProductItem)
    }
}