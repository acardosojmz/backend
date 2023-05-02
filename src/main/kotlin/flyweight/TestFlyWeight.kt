package flyweight

fun main() {

    val playList = PlayList("musica popular")
    playList.addPlayItem("La llorona")
    playList.addPlayItem("La martiniana")
    playList.addPlayItem("La llorona")
    playList.printList()
    playList.addPlayItem("La sandunga")
    playList.printList()

    val productosElectrodomesticos = ProductList("Electrodomésticos")
    productosElectrodomesticos.addItem("Celular samsung",23500.0, "samsung")
    productosElectrodomesticos.addItem("Televisor 50 pulgadas",30000.0,"LG")
    productosElectrodomesticos.addItem("Celular Huawei",18000.0,"Huawei")
    productosElectrodomesticos.addItem("Celular samsung",23500.0, "samsung")
    productosElectrodomesticos.printList()

}