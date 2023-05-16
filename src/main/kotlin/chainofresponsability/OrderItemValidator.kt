package chainofresponsability

class OrderItemValidator: OrderValidator()  {
    override fun validate(order: Order) {
        val orderItems = order.orderItems
        orderItems.forEach {
            val product = it.product
            if (it.quantity <=0){
                throw ValidationException("El producto '"
                        + product.name + "' no tiene cantidad")
            }
            val listPrice = product.listPrice
            val price = it.price
            val priceLimit = listPrice - (listPrice*0.2)
            if (price<priceLimit){
                throw  ValidationException("El precio del producto '"+
                        product.name +"' sobrepasa el límite permitido")
            }
        }
    }
}