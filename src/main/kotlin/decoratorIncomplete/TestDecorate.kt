package decoratorIncomplete

fun main(){
    val customerMessage = CustomerMessage(
        "Oscar Blancarte", "oscarblancarte3@gmail.com", "554433445566"
    )
    println("Original Message ==> $customerMessage")

    val message1 = EncryptMessage(
        "usuario", "HG58YZ3CR9123456",
        SOAPEnvelopMessage(
            XMLFormatterDecorate(customerMessage)
        )
    ).processMessage()
    println(
        "message1 =====================================>\n"
                + message1.getContent() + "\n\n"
    )
    val message2 = SOAPEnvelopMessage(
        EncryptMessage(
            "usuario", "HG58YZ3CR9123456",
            XMLFormatterDecorate(customerMessage)
        )
    ).processMessage()
    println(
        ("message2 =====================================>\n"
                + message2.getContent())
    )
}