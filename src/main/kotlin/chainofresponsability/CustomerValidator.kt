package chainofresponsability

class CustomerValidator: OrderValidator()  {
    override fun validate(order: Order) {
        for (validator in validators) {
            validator.validate(order)
        }
        if (order.contributor !is Customer) {
            throw ValidationException("El contribuyente no es un cliente")
        }
    }

}