package templatemethod

import java.io.File

class Log {
    companion object {
        fun buildLog(id: Int, customer: Int, date:String,amount: Double): String {
            val isExist = OnMemoryDataBase.customerExist(customer)
            if (!isExist) {
                return "$id E$customer\t\t$date El cliente no existe\n"
            }  else if (amount > 200) {
                return "$id E$customer\t\t$date El monto excede el máximo\n"

            } else {
                return "$id E$customer\t\t$date Aplicado exitosamente\n";

            }
        }
        fun create(fileName: String, data: String){
            val outFile = File(fileName)
            if (!outFile.exists()){
                outFile.createNewFile()
            }
            File(fileName).writeText(data)

        }
    }
}