package decorator_v2

fun main(){
    val customerMessage = CustomerMessage(Customer(
        "Ambrosio Cardoso Jimenez", "cardosojmz@gmail.com", "9513618396").toString()
    )
    println("Original Message ==> ${customerMessage.getContent()} ")

    val message1 = EncryptMessage(
        "usuario", "HG58YZ3CR9123456",
        SOAPEnvelopMessage(
            XMLFormatterDecorate(customerMessage)
        )
    ).processMessage().getContent()
    println(
        "message1 =====================================>\n"
                + message1 + "\n\n"
    )

    val message2 = SOAPEnvelopMessage(
        EncryptMessage(
            "usuario", "HG58YZ3CR9123456",
            XMLFormatterDecorate(customerMessage)
        )
    ).processMessage().getContent()
    println(
        ("message2 =====================================>\n"
                + message2)
    )
}