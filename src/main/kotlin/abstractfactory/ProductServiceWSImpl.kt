package abstractfactory

class ProductServiceWSImpl: IProductService {
    private val products = listOf("SOA-Refresco", "SOA-Jugo", "SOA-Fruta")
    override fun getProducts(): List<String> {
        return  this.products
    }
}