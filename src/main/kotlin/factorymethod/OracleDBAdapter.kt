package factorymethod

import properties.PropertiesUtil.loadProperty
import java.sql.Connection
import java.sql.DriverManager


class OracleDBAdapter: IDBAdapter {
    private val _DB_PROPERTIES = "properties/DBOracle"
    private val _DB_SERVICE_PROP = "service"
    private val _DB_HOST_PROP = "host"
    private val _DB_PASSWORD_PROP = "password"
    private val _DB_PORT_PROP = "port"
    private val _DB_USER_PROP = "user"
    override fun getConnection(): Connection? {
        return try {
            Class.forName("oracle.jdbc.OracleDriver")
            val connectionString: String = createConnectionString()
            DriverManager.getConnection(connectionString)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }

    }

    private fun createConnectionString(): String {
        val prop = loadProperty(_DB_PROPERTIES)
        val host = prop!!.getProperty(_DB_HOST_PROP)
        val port = prop!!.getProperty(_DB_PORT_PROP)
        val service = prop!!.getProperty(_DB_SERVICE_PROP)
        val user = prop!!.getProperty(_DB_USER_PROP)
        val password = prop!!.getProperty(_DB_PASSWORD_PROP)
        return ("jdbc:oracle:thin:"
                + user + "/" + password + "@//" + host + ":" + port + "/" + service)
    }
}