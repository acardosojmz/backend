package adapter

class XBankCreditAdaptee: IBankAdapter{
    override fun sendCreditRequest(request: BankCreditRequest): BankCreditResponse {
        val xRequest = XBankCreditRequest(request.customer, request.amount)

        val api = XBankCreditAPI()

        val xResponse =  BankCreditResponse()
        xResponse.approved= api.sendCreditRequest(xRequest)!!.approval

        return (xResponse)
    }
}