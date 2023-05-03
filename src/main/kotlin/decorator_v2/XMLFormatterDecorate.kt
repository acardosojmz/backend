package decorator_v2




import org.json.JSONObject
import org.json.XML
class XMLFormatterDecorate(private var message:IMessage): MessageDecorator(message) {
    override fun processMessage(): IMessage {
        message = message.processMessage()
        message = xmlMessage()
        return message
    }
    private fun xmlMessage(): IMessage {
        val json = JSONObject(message)
        val xml = XML.toString(json)
        return  TextMessage(xml)
    }
}