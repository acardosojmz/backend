package command

import java.io.OutputStream


abstract class BaseCommand: ICommand {
    abstract override fun getCommandName(): String

    abstract override fun execute(args: Array<String>, out: OutputStream)
    open fun write(out: OutputStream, message: String) {
        try {
            out.write(message.toByteArray())
            out.flush()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}