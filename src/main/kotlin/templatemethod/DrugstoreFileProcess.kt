package templatemethod

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream







class DrugstoreFileProcess (file: File, logPath:String, movePath:String):
    TemplateFileProcess(file, logPath, movePath) {

    private var log = ""
    override fun validateName() {
        val fileName = file.name
        if (!fileName.endsWith(".drug")) {
            throw Exception(
                "Nombre el archivo no válido"
                        + ", debe terminar con .drug"
            )
        }

        if (fileName.length != 16) {
            throw Exception("El documento no tiene el formato esperado")
        }
    }

    override fun processFile() {
        val input = FileInputStream(file)

        try {
            val fileContent = ByteArray(input.available())

            input.read(fileContent)

            val message = fileContent.toString()

            val lines = message.split("\n")

            lines.forEach {
                val id= it.substring(0,3)
                val customer = it.substring(3,5)
                val amount = it.substring(5,8).toDouble()
                val date =  it.substring(8,16)
                val isExist = OnMemoryDataBase.customerExist(customer.toInt())
                if (!isExist) {
                    log += "$id E$customer\t\t$date El cliente no existe\n"
                }  else if (amount > 200) {
                    log += "$id E$customer\t\t$date El monto excede el máximo\n"

                } else {
                    log += "$id E$customer\t\t$date Aplicado exitosamente\n";

                }

            }

        } finally {
            try {
                input.close()
            } catch ( e: Exception) {
            }
        }
    }

    override fun createLog() {
        var out: FileOutputStream? = null
        try {
            val outFile = File(logPath + "/" + file.name)
            if (!outFile.exists()) {
                outFile.createNewFile()
            }
            out = FileOutputStream(outFile, false)
            out.write(log.toByteArray())
            out.flush()
        } finally {
            out!!.close()
        }

    }
}