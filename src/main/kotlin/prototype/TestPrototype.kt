package prototype

fun main(){
    val standardPriceProducts = PriceList("Standard Price List",products = arrayListOf())
    for (c in 1..5) {
        val item = ProductItem("Product $c", (c * 2).toDouble())
        standardPriceProducts.addProductItem(item)
    }
    PrototypeFactory.addPrototype(
        standardPriceProducts.listName, standardPriceProducts
    )
    //--- Segunda lista para clientes de mayoreo a partir de la lista
    //--- estándar con un 10% de descuento sobre la lista de precio estándar.
    val wholesalePriceProducts: PriceList = PrototypeFactory.getPrototype("Standard Price List") as PriceList
    wholesalePriceProducts.listName= "Wholesale Price List"
    for (item in wholesalePriceProducts.products) {
        item.price = item.price * 0.90
    }
    PrototypeFactory.addPrototype(
        wholesalePriceProducts.listName, wholesalePriceProducts
    )
    //--- Tercera lista de precios para clientes VIP a partir de la lista
    //--- de mayoreo con 10% de descuento sobre la lista de precios de mayoreo.
    val vipPriceProducts: PriceList = PrototypeFactory.getPrototype("Wholesale Price List") as PriceList
    vipPriceProducts.listName= "VIP Price List"
    for (item in vipPriceProducts.products) {
        item.price = item.price * 0.90
    }

    println(standardPriceProducts)
    println(wholesalePriceProducts)
    println(vipPriceProducts)
}