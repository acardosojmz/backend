
import factorymethod.Product
import factorymethod.ProductDAO


fun main() {

    val productDAO= ProductDAO()
    val products = productDAO.findAllProducts()

    println("before save")

    products!!.forEach {  println(it.toString()) }

    //--- insert new product
    print("Introduzca el producto: ")

    val description = readLine()!!
    print ("Introduzca el precio: ")
    val price =  readLine()!!.toDouble()

    val product= Product(id=0, description = description,price)
    productDAO.saveProduct(product)
    println("-------------------------------------")
    println(" ${product.description},  ${product.price}" )
}

