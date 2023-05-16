package chainofresponsability

class CreditValidator: OrderValidator()  {
    override fun validate(order: Order) {
        val total = order.getTotal()
        val creditData = order.contributor.creditData
        val newBalance = creditData.balance + total
        if(newBalance > creditData.creditLimit) {
            throw ValidationException("El monto de la orden excede el "
                    + "límite de crédito disponible");
        }
    }


}