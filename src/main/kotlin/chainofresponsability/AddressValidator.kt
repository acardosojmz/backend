package chainofresponsability

class AddressValidator: OrderValidator() {
    override fun validate(order: Order) {
        val address: Address = order.contributor.address
        if (address.address1.length === 0) {
            throw ValidationException("La dirección 1 es obligatoria")
        } else if (address.cp.length !== 4) {
            throw ValidationException("El CP debe de ser de 4 dígitos")
        } else if (address.country.length === 0) {
            throw ValidationException("El país es obligatorio")
        }
    }

}