package interpreter

import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Row
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class Context(private var dbPath: String?) {
    private var dateFormat: SimpleDateFormat? = null
    private var workboook: HSSFWorkbook? = null
    private var sheets: HSSFSheet? = null
    private var columns: Array<String?>?= null
    private var tableIterator: Iterator<Row>? = null
    private val resultRows: MutableList<Row?> = ArrayList<Row?>()
    private var currentRow: Row? = null
    private var result: MutableList<Array<Any?>>? = null
    private var resultColumnCount = 0

    init {
        initiateFileRead()
    }

    fun createResultArray(columns: Int) {
        resultColumnCount = columns
        result = ArrayList()
    }

    fun getDateFormat(): SimpleDateFormat? {
        return dateFormat
    }

    fun setDateFormat(dateFormat: SimpleDateFormat?) {
        this.dateFormat = dateFormat
    }

    fun getResultArray(): List<Array<Any?>>? {
        return result
    }

    fun createRow(): Array<Any?>? {
        val row = arrayOfNulls<Any>(resultColumnCount)
        result!!.add(row)
        return row
    }

    fun getResultRow(): List<Row?>? {
        return resultRows
    }

    private fun initiateFileRead() {
        try {
            println("dbPath > $dbPath")
            workboook = HSSFWorkbook(
                Context::class.java.classLoader
                    .getResourceAsStream(dbPath)
            )
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun createRowIterator() {
        tableIterator = sheets!!.iterator()
        tableIterator!!.next()
    }

    fun getCurrentRow(): Row? {
        return currentRow
    }

    fun nextRow(): Boolean {
        if (tableIterator!!.hasNext()) {
            currentRow = tableIterator!!.next()
            return true
        }
        return false
    }

    fun getRowIterator(): Iterator<Row?>? {
        return tableIterator
    }

    fun addCurrentRowToResults() {
        resultRows.add(currentRow)
    }

    fun destroy() {
        try {
            workboook!!.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun tableExist(table: String): Boolean {
        return loadTable(table)
    }

    private fun loadTable(table: String): Boolean {
        if (columns != null) {
            return true
        }
        sheets = workboook!!.getSheet(table)
        if (sheets == null) {
            return false
        }
        for (row: Row in sheets!!) {
            val lastRow: Int = row!!.lastCellNum as Int
            println("lastRow > $lastRow")
            columns = arrayOfNulls(lastRow)
            var index = 0
            for (cell in row) {
                columns!![index++] = cell.stringCellValue
            }
            println(
                "Table > '" + table + "' Columns > '"
                        + Arrays.toString(columns) + "'"
            )
            break
        }
        return true
    }

    fun tableColumn(column: String?): Boolean {
        for (col: String? in columns!!) {
            if (col.equals(column, ignoreCase = true)) {
                return true
            }
        }
        return false
    }

    fun columnIndex(column: String): Int {
        for (c in columns!!.indices) {
            if (columns!![c].equals(column, ignoreCase = true)) {
                return c
            }
        }
        throw RuntimeException("Columna '$column' no existe")
    }
}