package decorator_v2

class CustomerMessage(private var content: String) : IMessage {
    override fun processMessage(): IMessage {
        return this
    }

    override fun getContent(): String {
        return this.content
    }

    override fun setContent(content: String): Unit{
        this.content=content
    }




}