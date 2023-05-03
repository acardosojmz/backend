package decorator_v2

class TextMessage(private var content: String): IMessage {

    override fun processMessage(): IMessage {
        return this
    }

    override fun getContent(): String {
        return this.content
    }

    override fun setContent(content: String) {
        this.content = content
    }

}