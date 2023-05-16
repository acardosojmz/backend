package strategy

import factorymethod.MySqlDBAdapter
import java.security.Principal
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement


class SQLAuthenticationProvider : IAuthenticationStrategy {
    private val  query = "SELECT userName, rol from user where userName=? and password = ?"
    private var mysqlAdapter: MySqlDBAdapter = MySqlDBAdapter()
    override fun authenticate(userName: String?, password: String?): Credential? {
        return try {
            val connection: Connection? = mysqlAdapter.getConnection()
            val statement = connection!!.prepareStatement(query)

            statement.setString(1, userName)
            statement.setString(2, password)

            val results  = statement.executeQuery()
            while (results.next()) {
                return Credential(results.getString("userName"), results.getString("rol"))
            }
            results.close()
            statement.close()
            null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

}