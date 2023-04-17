package bridge

import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.DESKeySpec
import java.util.Base64

class DESEncryptAlgorithm: IEncryptAlgorithm {
    override fun encrypt(message: String, password: String): String {
        val dks = DESKeySpec(message.toByteArray())
        val skf = SecretKeyFactory.getInstance("DES")
        val desKey = skf.generateSecret(dks)
        val desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding")
        desCipher.init(Cipher.ENCRYPT_MODE, desKey)

        return Base64.getEncoder().encodeToString(desCipher.doFinal(message.toByteArray()))

    }
}