package chainofresponsability

import java.time.LocalDate


abstract class Order   {
    abstract val createDate: LocalDate
    abstract val contributor: Contributor
    abstract val orderItems: List<OrderItem>

    open fun getTotal(): Double {
        return orderItems.sumOf { it.getTotal() }
    }
}