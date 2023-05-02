package flyweight

class ProductList (private val categoryProduct:  String) {
    private var products= ArrayList<Product?>()
    fun addItem(descriptionProduct: String, price: Double, brand: String){
        products.add(ProductFactory.createProduct(descriptionProduct, price, brand ));
    }

    fun printList(){
        var out = "\nProducts > $categoryProduct \n"
        products.forEach {
            out+=it.toString() + "\n"
        }
        println(out)
    }
}