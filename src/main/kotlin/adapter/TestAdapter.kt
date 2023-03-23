package adapter


fun main() {

    val request = BankCreditRequest("Ambrosio Cardoso", 1000.00)

    val xBank: IBankAdapter = XBankCreditAdaptee()
    val xresponse = xBank.sendCreditRequest(request)
    println(
        """
            ${"xBank approved > " + xresponse.approved}
            
            """.trimIndent()
    )
    val yBank: IBankAdapter = YBankCreditAdaptee()
    val yresponse = yBank.sendCreditRequest(request)
    println(
        """
            ${"yBank approved > " + yresponse.approved}
            
            """.trimIndent()
    )
    if (xresponse.approved) {
        println("xBank aprobó su crédito, felicidades!!")
    } else if (yresponse.approved) {
        println("yBank aprobó su crédito, felicidades!!")
    } else {
        println("lo sentimos su crédito no ha sido aprobado")
    }
}