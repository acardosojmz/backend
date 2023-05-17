package chainofresponsability

class CustomerValidator: OrderValidator()  {
    override fun validate(order: Order) {
        validators.forEach { it.validate(order) }

        if (order.contributor !is Customer) {
            throw ValidationException("El contribuyente no es un cliente")
        }
    }

}