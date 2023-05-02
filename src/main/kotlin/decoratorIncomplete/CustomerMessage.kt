package decoratorIncomplete

class CustomerMessage(private val name: String, private val email: String, private val telephone: String) : IMessage {
    override fun processMessage(): IMessage {
        return this
    }

    override fun getContent(): String {
        return toString()
    }

    override fun setContent(content: String) {
        println("No is implemented")
    }


    override fun toString():String{
        return "QueryCustomerMessage{name=$name, email=$email, telephone=$telephone}"
    }

}