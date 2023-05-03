package decorator_v2

interface IMessage {
    fun processMessage(): IMessage
    fun getContent(): String
    fun setContent(content:String)
}