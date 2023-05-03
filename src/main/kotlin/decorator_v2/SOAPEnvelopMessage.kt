package decorator_v2

class SOAPEnvelopMessage(private var message: IMessage): MessageDecorator(message) {
    override fun processMessage(): IMessage {
        message.processMessage()
        message = envelopMessage()
        return message
    }

    private fun envelopMessage(): IMessage {
        val soap =
            """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://service.dishweb.cl.com/">
             <soapenv:Header/>
             <soapenv:Body>
            ${message.getContent()}
             </soapenv:Body>
            </soapenv:Envelope>"""
        message.setContent(soap)
        return message
    }
}