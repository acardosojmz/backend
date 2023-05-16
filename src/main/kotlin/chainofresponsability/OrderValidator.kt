package chainofresponsability


abstract class OrderValidator {
    var validators: MutableList<OrderValidator> = ArrayList()

    abstract fun validate(order: Order)

    fun addValidator(validator: OrderValidator) {
        validators.add(validator)
    }
}