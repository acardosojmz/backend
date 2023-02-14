package properties

import java.util.*



object PropertiesUtil {
    fun loadProperty(propertiesURL: String?): Properties? {
        return try {
            val properties = Properties()
            val inputStream = PropertiesUtil::class.java
                .classLoader.getResourceAsStream(propertiesURL)
            properties.load(inputStream)
            properties
        } catch (e: Exception) {
            //e.printStackTrace()
            null
        }
    }
}