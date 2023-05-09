package command

import java.io.OutputStream
import java.util.*


class EchoCommand: BaseCommand() {
    companion object{
        const val COMMANDNAME = "echo"
    }
    override fun getCommandName(): String {
        return COMMANDNAME
    }

    override fun execute(args: Array<String>, out: OutputStream) {
        val message = getCommandName() + " " + args.contentToString()
        write(out, message)
    }
}