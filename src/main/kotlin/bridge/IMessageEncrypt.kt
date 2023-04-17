package bridge

interface IMessageEncrypt {
    @Throws(Exception::class)
    fun encryptMessage(message: String?, password: String?): String?
}