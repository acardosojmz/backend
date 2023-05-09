package command

import java.io.File
import java.io.FileWriter
import java.io.OutputStream


class FileCommand: BaseCommand() {
    companion object{
        const val COMMANDNAME = "file"
    }
    private val WRITE_APPEND = "-WA"
    private val WRITE_OVERRIDE = "-WO"
    private val WRITE_NEW = "-WN"
    private val RENAME_FILE = "-R"
    private val DELETE_FILE = "-D"
    override fun getCommandName(): String {
        return COMMANDNAME
    }

    override fun execute(args: Array<String>, out: OutputStream) {
        if (args.size < 2) {
            write(out, "Insufficient parameters ")
            return
        }
        val operation = args[0].uppercase()

        val reduce = args.copyOfRange(1, args.size)
        if (WRITE_APPEND == operation) {
            write(out, writeAppend(reduce))
        } else if (WRITE_NEW == operation) {
            write(out, writeNew(reduce))
        } else if (WRITE_OVERRIDE == operation) {
            write(out, writeOverride(reduce))
        } else if (RENAME_FILE == operation) {
            write(out, renameFile(reduce))
        } else if (DELETE_FILE == operation) {
            write(out, deleteFile(reduce))
        } else {
            write(
                out, "Not found operation  {"
                        + WRITE_APPEND + "|" + WRITE_NEW + "|" + WRITE_OVERRIDE + "|"
                        + RENAME_FILE + "|DELETE_FILE}"
            )
        }

    }

    private fun renameFile(args: Array<String>): String {
        val filePath = args[0]
        val newFileName = args[1]
        return try {
            val file = File(filePath)
            file.renameTo(File(newFileName))
            ""
        } catch (e: Exception) {
            "ERROR: " + e.message
        }
    }

    private fun writeOverride(args: Array<String>): String {
        val filePath = args[0]
        val fileContent = args[1]
        return try {
            val file = File(filePath)
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    return "ERROR: Error creating file"
                }
            }
            val fileW = FileWriter(file)
            fileW.write(fileContent.toCharArray())
            fileW.flush()
            fileW.close()
            ""
        } catch (e: Exception) {
            "ERROR: " + e.message
        }
    }

    private fun writeAppend(args: Array<String>): String {
        val filePath = args[0]
        val fileContent = args[1]
        return try {
            val file = File(filePath)
            if (!file.exists()) {
                return "ERROR: File not found"
            }
            val fileW = FileWriter(file, true)
            fileW.append(fileContent)
            fileW.flush()
            fileW.close()
            ""
        } catch (e: Exception) {
            "ERROR: " + e.message
        }
    }

    private fun writeNew(args: Array<String>): String {
        val filePath = args[0]
        val fileContent = args[1]

        println("FILE: $filePath, CONTENT: $fileContent")
        return try {
            val file = File(filePath)
            if (file.exists()) {
                return "ERROR: Already exists file $filePath"
            }
            if (!file.createNewFile()) {
                return "ERROR: Could not create the file "
            }
            val fileW = FileWriter(file)
            fileW.write(fileContent.toCharArray())
            fileW.flush()
            fileW.close()
            ""
        } catch (e: Exception) {
            "ERROR: " + e.message
        }
    }

    private fun deleteFile(args: Array<String>): String {
        val filePath = args[0]
        val file = File(filePath)
        return if (!file.delete()) {
            "Could not delete the file"
        } else ""
    }
}