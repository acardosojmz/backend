package command

import java.io.OutputStream
import kotlin.system.exitProcess

class ExitCommand: ICommand {
    companion object{
        const val COMMANDNAME = "exit"
    }
    override fun getCommandName(): String {
        return  COMMANDNAME
    }

    override fun execute(args: Array<String>, out: OutputStream) {
        exitProcess(0);
    }

}