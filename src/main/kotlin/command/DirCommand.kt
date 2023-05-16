package command

import java.io.File
import java.io.OutputStream
import java.util.*


class DirCommand: BaseCommand() {
    companion object{
        const val COMMANDNAME = "dir"
    }
    override fun getCommandName(): String {
        return COMMANDNAME
    }

    override fun execute(args: Array<String>, out: OutputStream) {
        if (args.size < 2) {
            write(out, "$COMMANDNAME insufficient arguments ")
        }
        val operation = args[0]

        if ("-D" == operation.uppercase(Locale.getDefault())) {
            write(out, deleteDir(args[1]))
        } else if ("-N" == operation.uppercase(Locale.getDefault())) {
            write(out, newDir(args[1]))
        } else {
            write(out, " Parameters valid is -d | -n")
        }
    }

    private fun deleteDir(url: String): String{
        return try {
            val file = File(url)
            if (!file.exists()) {
                return "File not found"
            }
            if (!file.canWrite()) {
                return "Insufficient privileges"
            }
            file.delete()
            ""
        } catch (e: Exception) {
            "ERROR: " + e.message
        }
    }

    private fun newDir(url: String): String{
        try {

            val file =  File(url)

            if (file.exists()) {

                return "File $url already exists"

            }
            file.mkdirs()
            return ""
        } catch ( e: Exception) {
            return "ERROR: " + e.message
        }
    }

}