package decoratorIncomplete

interface IMessage {
    fun processMessage(): IMessage
    fun getContent(): String
    fun setContent(content:String)
}