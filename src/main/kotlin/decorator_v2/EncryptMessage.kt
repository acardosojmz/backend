package decorator_v2

import java.security.Key
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec


class EncryptMessage (private var user:String,
                      private var password: String,
                      private var message: IMessage): MessageDecorator(message) {
    override fun processMessage(): IMessage {
        message= message.processMessage()
        encryptMessage()
        return message
    }
    private fun encryptMessage(): IMessage? {
        return try {
            val key: Key = SecretKeySpec(password.toByteArray(), "AES")
            val c = Cipher.getInstance("AES")
            c.init(Cipher.ENCRYPT_MODE, key)
            val encVal = c.doFinal(message.getContent().toByteArray())
            val encryptedValue: String = Base64.getEncoder().encodeToString(encVal)

            message.setContent(encryptedValue)
            message
        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException()
        }
    }
}