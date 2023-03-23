package adapter

class XBankCreditAdaptee: IBankAdapter{
    override fun sendCreditRequest(request: BankCreditRequest): BankCreditResponse {
        val xrequest = XBankCreditRequest(request.customer, request.amount)

        val api = XBankCreditAPI()

        val xresponse: XBankCreditResponse = api.sendCreditRequest(xrequest)!!

        return BankCreditResponse()
    }

}