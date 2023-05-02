package flyweight

class ProductFactory {
    companion object {
        private val products  = hashMapOf<String, Product>()
        private var idSequence = 0L

        fun createProduct(descriptionProduct: String, price: Double, brand: String):
                Product? {
            return if( products.containsKey(descriptionProduct)) {
                products[descriptionProduct]
            } else {
                val product = Product(++idSequence, descriptionProduct, price, brand)
                products[descriptionProduct] = product
                product
            }
        }
    }
}