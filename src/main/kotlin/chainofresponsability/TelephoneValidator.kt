package chainofresponsability

class TelephoneValidator: OrderValidator()  {
    override fun validate(order: Order) {
        val tel: Telephone = order.contributor.telephone
        if (null == tel) {
            throw ValidationException(
                "El teléfono del contribuyente es obligatorio"
            )
        } else if (tel.number.length !== 7) {
            throw ValidationException("Número de teléfono inválido")
        } else if (tel.lada.length !== 3) {
            throw ValidationException("Lada inválida")
        }
    }

}