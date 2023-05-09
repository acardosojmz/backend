package command

import java.io.File
import java.io.FileInputStream
import java.io.OutputStream
import java.util.*


class BatchCommand: BaseCommand() {
    companion object{
        const val COMMANDNAME = "batch"
    }
    override fun getCommandName(): String {
        return COMMANDNAME
    }

    override fun execute(args: Array<String>, out: OutputStream) {
        if (args.isEmpty()) {
            write(out, "Invalid paramters number")
            return
        }

        val manager: CommandManager = CommandManager.getInstance()

        val lines= readLinesFromFile(args[0])

        for (line in lines) {
            val argsCommand: Array<String> = CommandUtil.tokenizerArgs(line!!)
            val command = manager.getCommand(argsCommand[0])
            val reduce = argsCommand.copyOfRange(1, argsCommand.size)
            command.execute(reduce, out)
            write(out, "\n")
        }
        write(out, "Running in Batch")
    }

    @Throws(RuntimeException::class)
    private fun readLinesFromFile(filePath: String): List<String?> {
        val file = File(filePath)
        var stream: FileInputStream? = null
        return try {
            if (!file.exists()) {
                throw RuntimeException("File not found")
            }
            stream = FileInputStream(file)
            val byteArray = ByteArray(stream.available())
            stream.read(byteArray)
            val commands = String(byteArray)
            commands.split("\n".toRegex()).dropLastWhile { it.isEmpty() }
        } catch (e: Exception) {
            throw RuntimeException(e.message)
        } finally {
            try {
                stream!!.close()
            } catch (e2: Exception) {

            }
        }
    }
}