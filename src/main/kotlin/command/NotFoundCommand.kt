package command

import java.io.OutputStream

class NotFoundCommand: BaseCommand() {
    companion object{
        const val COMMANDNAME = "notfound"
    }
    override fun getCommandName(): String {
        return COMMANDNAME
    }

    override fun execute(args: Array<String>, out: OutputStream) {
        write(out, "Command not found");
    }
}
