package chainofresponsability

class Customer (
    override val name: String,
    override val rfc: String,
    override val status: Status,
    override val address: Address,
    override val telephone: Telephone,
    override val creditData: CreditData
): Contributor( name, rfc, status, address, telephone, creditData
   ) 