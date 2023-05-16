package strategy

import org.w3c.dom.Document
import java.io.IOException
import java.io.InputStream
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPath
import javax.xml.xpath.XPathFactory


class XMLAuthenticationProvider: IAuthenticationStrategy {
    private val rolXPath = "Users/User[@userName='%s' and @password='%s']/@rol"
    override fun authenticate(userName: String?, password: String?): Credential? {
        var file: InputStream? = null
        return try {
            file = javaClass.getResourceAsStream("users.xml")
            val builderFactory = DocumentBuilderFactory.newInstance()
            val builder = builderFactory.newDocumentBuilder()
            val xmlDocument: Document = builder.parse(file)
            val xPath: XPath = XPathFactory.newInstance().newXPath()
            val xpath = java.lang.String.format(rolXPath, userName, password)
            val rol: String = xPath.compile(xpath).evaluate(xmlDocument)
            if (rol.isNotEmpty()) {
                Credential(userName, rol)
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        } finally {
            try {
                file!!.close()
            } catch (ex: IOException) {
            }
        }
    }

}