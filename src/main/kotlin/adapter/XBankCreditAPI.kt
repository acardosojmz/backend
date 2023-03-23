package adapter

class XBankCreditAPI {
    fun sendCreditRequest(request: XBankCreditRequest): XBankCreditResponse? {
        val response = XBankCreditResponse()
        response.approval = request.requestAmount<= 5000
        return response
    }
}