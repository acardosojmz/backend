package templatemethod

import java.io.File

abstract class TemplateFileProcess {
    protected var movePath: String
    protected var file: File
    protected var logPath: String
    constructor(file: File, logPath:String, movePath:String){
        this.file = file;
        this.logPath = logPath;
        this.movePath = movePath;
    }

    @Throws(Exception::class)
    fun execute() {
        validateName()
        validateProcess()
        processFile()
        createLog()
        moveDocument()
        markAsProcessFile()
    }

    @Throws(java.lang.Exception::class)
    protected abstract fun validateName()
    @Throws(java.lang.Exception::class)
    protected open fun validateProcess() {
        val fileStatus: String = OnMemoryDataBase.getFileStatus(file.name)
        if (fileStatus != null && fileStatus == "Procesado") {
            throw java.lang.Exception("El archivo '" + file.name + "' ya fue procesado")
        }
    }
    @Throws(java.lang.Exception::class)
    protected abstract fun processFile()
    @Throws(java.lang.Exception::class)
    protected abstract fun createLog()

    @Throws(java.lang.Exception::class)
    open fun moveDocument() {
        val newPath = movePath + "/" + file.name
        val change = file.renameTo(File(newPath))
    }
    @Throws(java.lang.Exception::class)
    protected open fun markAsProcessFile() {
        OnMemoryDataBase.setProcessFile(file.name)
    }
}