package prototype


data class PriceList(
    var listName: String,
    var products: ArrayList<ProductItem>
    ): IPrototype<PriceList>{
    override fun clone(): Any {
        return PriceList(listName=listName, products=this.products)
    }
    override fun deepClone(): PriceList {
        val cloneProducts: ArrayList<ProductItem> = ArrayList()
        for (item in products) {
            val cloneItem: ProductItem = item.clone() as ProductItem
            cloneProducts.add(cloneItem)
        }
        return PriceList(listName, products=cloneProducts)
    }
    fun addProductItem (item: ProductItem){
        this.products.add(item)
    }
}
