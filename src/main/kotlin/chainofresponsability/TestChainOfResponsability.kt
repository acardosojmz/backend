package chainofresponsability

import java.time.LocalDate
import java.util.*


fun main() {
    val telephone = Telephone("951","3618396","")
    val address = Address("Address 1","Address 2","Mexico","7123")
    val creditData =  CreditData(20000.0,2000.0)
    val customer: Contributor= Customer("Ambrosio Cardoso","CAJA7412079W5",Status.ACTIVO, address,telephone,creditData)

    val orderItems: ArrayList<OrderItem> = ArrayList()
    for (c in 0..9) {
        val item = OrderItem(product = Product(
            name="Product " + (c + 1),  listPrice =(c + 1) * 32.0 ), price = ((c + 1) * 30.0), quantity = c+1.0)
        orderItems.add(item)
    }
    val salesOrder = SalesOrder(LocalDate.now(), customer, orderItems)

    println("Total orden > " + salesOrder.getTotal())

    try {
        val validator: OrderValidator = OrderValidatorBuilder.buildSalesOrderValidator()
        validator.validate(salesOrder)
        println("Validación exitosa")
    } catch (e: Exception) {
        System.err.println(e.message)
        e.printStackTrace()
    }

}