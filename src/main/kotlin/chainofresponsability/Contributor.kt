package chainofresponsability

abstract class Contributor (
    open val name: String,
    open val rfc: String,
    open val status: Status,
    open val address: Address,
    open val telephone: Telephone,
    open val creditData: CreditData,
)