package templatemethod


class OnMemoryDataBase {
    companion object {
        private val PROCESS_DOCUMENTS: MutableMap<String, String> = HashMap()

        private val CUSTOMERS = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100)
        fun getFileStatus(fileName: String) : String {
            return PROCESS_DOCUMENTS[fileName].toString()

        }

        fun setProcessFile(fileName: String) {
            PROCESS_DOCUMENTS[fileName] = "Procesado"
        }

        fun customerExist(id: Int): Boolean {
            return !CUSTOMERS.none { it == id }
        }
    }
}