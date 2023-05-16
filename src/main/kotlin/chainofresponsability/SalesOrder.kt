package chainofresponsability

import java.time.LocalDate

class SalesOrder(
    override val createDate: LocalDate,
    override val contributor: Contributor,
    override val orderItems: List<OrderItem>
) : Order()