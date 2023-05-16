package templatemethod

import java.io.File

class GroceryFileProcess(file: File, logPath:String, movePath:String):
    TemplateFileProcess(file, logPath, movePath)  {
    private var log = ""
    override fun validateName() {
        val fileName = file.name
        if (!fileName.endsWith(".gry")) {
            throw Exception(
                "Nombre el archivo no válido"
                        + ", debe terminar con .gry"
            )
        }
    }

    override fun processFile() {
        File(file.name).forEachLine {
            val parts = it.split(",")
            if (parts.size>=4) {
                val id = parts[0].toInt()
                val customer = parts[1].toInt()
                val amount = parts[2].toDouble()
                val date = parts[3]
                log += Log.buildLog(id, customer,date,amount)
            }

        }

    }

    override fun createLog() {
        Log.create(logPath + "/" + file.name, log)
    }
}