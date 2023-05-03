package decorator_v2

abstract class MessageDecorator (private val message: IMessage): IMessage {

    override fun getContent(): String {
        return message.getContent()
    }

    override fun setContent(content: String) {
        message.setContent(content);
    }
}