package adapter

interface IBankAdapter {
    fun sendCreditRequest( request: BankCreditRequest): BankCreditResponse
}
