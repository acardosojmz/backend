package chainofresponsability

data class OrderItem(val product: Product,
                     val price: Double,
                     val quantity: Double ){
    fun getTotal(): Double {
        return price * quantity
    }
}
