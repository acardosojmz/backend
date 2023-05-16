package templatemethod

import java.io.File

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

    }

    override fun processFile() {
        File(file.name).forEachLine {
            val id= it.substring(0,3).toInt()
            val customer = it.substring(3,5).toInt()
            val amount = it.substring(5,8).toDouble()
            val date =  it.substring(8,16)
            log += Log.buildLog(id, customer,date,amount)
        }

    }

    override fun createLog() {
        Log.create(logPath + "/" + file.name, log)
    }
}