package adapter

interface YBankCreditSenderListener {
    fun notifyCreditResult(result: YBankCreditApproveResult?)
}