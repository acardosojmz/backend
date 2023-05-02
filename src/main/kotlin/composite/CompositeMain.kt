package composite


class CompositeMain {

    private lateinit var ram4gb: SimpleProduct
    private lateinit var ram8gb: SimpleProduct
    private lateinit var disk500gb: SimpleProduct
    private lateinit var disk1tb: SimpleProduct
    private lateinit var cpuAMD: SimpleProduct
    private lateinit var cpuIntel: SimpleProduct
    private lateinit var smallCabinete: SimpleProduct
    private lateinit var bigCabinete: SimpleProduct
    private lateinit var monitor20inch: SimpleProduct
    private lateinit var monitor30inch: SimpleProduct
    private lateinit var simpleMouse: SimpleProduct
    private lateinit var gammerMouse: SimpleProduct
    private lateinit var gammerPC: CompositeProduct
    private lateinit var homePC: CompositeProduct
    private lateinit var pc2x1: CompositeProduct

    fun buildProducts(){
        ram4gb = SimpleProduct("Memoria RAM 4GB", 750.0, "KingStone")
        ram8gb = SimpleProduct("Memoria RAM 8GB", 1000.0, "KingStone")
        disk500gb = SimpleProduct("Disco Duro 500GB", 1500.0, "ACME")
        disk1tb = SimpleProduct("Disco Duro 1TB", 2000.0, "ACME")
        cpuAMD = SimpleProduct("AMD phenon", 4000.0, "AMD")
        cpuIntel = SimpleProduct("Intel i7", 4500.0, "Intel")
        smallCabinete = SimpleProduct("Gabinete Pequeï¿½o", 2000.0, "ExCom")
        bigCabinete = SimpleProduct("Gabinete Grande", 2200.0, "ExCom")
        monitor20inch = SimpleProduct("Monitor 20'", 1500.0, "HP")
        monitor30inch = SimpleProduct("Monitor 30'", 2000.0, "HP")
        simpleMouse = SimpleProduct("Raton Simple", 150.0, "Genius")
        gammerMouse = SimpleProduct("Raton Gammer", 750.0, "Alien")
        //Computadora para Gammer que incluye 8gb de ram,disco de 1tb, procesador Intel i7
        //Gabinete grande, monitor de 30' y un mouse gammer.
        //Computadora para Gammer que incluye 8gb de ram,disco de 1tb, procesador Intel i7
        //Gabinete grande, monitor de 30' y un mouse gammer.
        gammerPC = CompositeProduct("Gammer PC")
        gammerPC.addProduct(ram8gb)
        gammerPC.addProduct(disk1tb)
        gammerPC.addProduct(cpuIntel)
        gammerPC.addProduct(bigCabinete)
        gammerPC.addProduct(monitor30inch)
        gammerPC.addProduct(gammerMouse)
        //Computadora para Casa que incluye 4gb de ram,disco de 500gb, procesador AMD Phenon
        //Gabinete chico, monitor de 20' y un mouse simple.
        //Computadora para Casa que incluye 4gb de ram,disco de 500gb, procesador AMD Phenon
        //Gabinete chico, monitor de 20' y un mouse simple.
        homePC = CompositeProduct("PC for Home")
        homePC.addProduct(ram4gb) //

        homePC.addProduct(disk500gb)
        homePC.addProduct(cpuAMD)
        homePC.addProduct(smallCabinete)
        homePC.addProduct(monitor20inch)
        homePC.addProduct(simpleMouse)
        //Paque compuesto de dos paquetes: paquete Gammer PC y Home PC
        //Paque compuesto de dos paquetes: paquete Gammer PC y Home PC
        pc2x1 = CompositeProduct("Paquete PC Gammer + Casa")
        pc2x1.addProduct(gammerPC)
        pc2x1.addProduct(homePC)
    }
    fun orderSimpleProducts(){
        val simpleProductOrder = SaleOrder(1, "Rosa Maria")
        simpleProductOrder.addProduct(ram4gb)
        simpleProductOrder.addProduct(disk1tb)
        simpleProductOrder.addProduct(simpleMouse)
        simpleProductOrder.printOrder()
    }
    fun orderGammerPC(){
        val gammerOrder = SaleOrder(2, "Zenaida Cruz")
        gammerOrder.addProduct(gammerPC)
        gammerOrder.printOrder()
    }
    fun orderHomePC() {
        val homeOrder = SaleOrder(3, "Angela Martinez")
        homeOrder.addProduct(homePC)
        homeOrder.printOrder()
    }

    fun orderCombo() {
        val comboOrder = SaleOrder(4, "Paquete 2x1 en PC")
        comboOrder.addProduct(pc2x1)
        comboOrder.printOrder()
    }

    fun orderBig() {
        val customOrder = SaleOrder(5, "Ambrosio Cardoso")
        customOrder.addProduct(homePC)
        customOrder.addProduct(ram8gb)
        customOrder.addProduct(ram4gb)
        customOrder.addProduct(monitor30inch)
        customOrder.addProduct(gammerMouse)
        customOrder.printOrder()
    }
}