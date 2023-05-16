package chainofresponsability

class ContributorValidator: OrderValidator()  {
    override fun validate(order: Order) {

        for (validator in validators) {
            validator.validate(order)
        }
        val contributor: Contributor = order.contributor
        if (Status.ACTIVO !== contributor.status) {
            throw ValidationException("El contribuyente no está activo")
        }
    }

}