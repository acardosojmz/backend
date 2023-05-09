package command

import java.io.OutputStream

class ErrorCommand: BaseCommand() {
    companion object{
        const val COMMANDNAME = "error"
    }
    override fun getCommandName(): String {
        return COMMANDNAME
    }

    override fun execute(args: Array<String>, out: OutputStream) {
        val message = "Error invoking command"
        write(out, message)
    }

}