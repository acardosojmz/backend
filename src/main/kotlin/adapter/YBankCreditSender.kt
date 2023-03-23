package adapter

class YBankCreditSender {
    fun sendCreditForValidate(request: YBankCreditApprove, listener: YBankCreditSenderListener) {
        Thread {
            println("YBank recibió la solicitud en un momento y tendrá la respuesta, sea paciente por favor")
            val response = YBankCreditApproveResult()
            response.approved =  request.credit <= 1500
            try {
                Thread.sleep((1000 * 30).toLong())
            } catch (e: Exception) {
                e.printStackTrace()
            }
            listener.notifyCreditResult(response)
        }.start()
    }
}