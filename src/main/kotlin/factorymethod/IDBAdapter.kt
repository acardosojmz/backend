package factorymethod

import java.sql.Connection

interface IDBAdapter {
    fun getConnection(): Connection?
}