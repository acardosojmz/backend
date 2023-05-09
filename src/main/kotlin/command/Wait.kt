package command

import java.io.OutputStream

class Wait: AsyncCommand() {
    companion object{
        val COMMANDNAME = "wait"
    }

    override fun executeOnBackground(args: Array<String>, out: OutputStream) {
        if (args.isEmpty()) {
            write(out, "Insufficient parameters")
            return
        }

       val time = args[0].toLong()
        try {
            Thread.sleep(time)
            write(out, "Hello!!");
        } catch ( e: Exception) {
            e.printStackTrace();
        }
    }


    override fun getCommandName(): String {
        return COMMANDNAME
    }

}