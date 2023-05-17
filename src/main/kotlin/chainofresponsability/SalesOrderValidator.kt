package chainofresponsability

class SalesOrderValidator: OrderValidator()  {
    override fun validate(order: Order) {
        if (order !is SalesOrder) {
            throw ValidationException("Se esperaba una orden de Venta")
        }
        validators.forEach { it.validate(order) }

    }

}