package adapter

class YBankCreditAdaptee : IBankAdapter, YBankCreditSenderListener {
    private var yresponse: YBankCreditApproveResult? = null
    override fun sendCreditRequest(request: BankCreditRequest): BankCreditResponse {
        val yrequest = YBankCreditApprove(request.customer, request.amount)
        val sender = YBankCreditSender()
        sender.sendCreditForValidate(yrequest, this)
        do {
            try {
                Thread.sleep(10000)
                println("YBank petición en espera....")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } while (yresponse == null)
        val response = BankCreditResponse()
        response.approved= yresponse!!.approved
        return response
    }

    override fun notifyCreditResult(result: YBankCreditApproveResult?) {
        yresponse = result
    }
}
