package command

import java.io.OutputStream
import java.text.SimpleDateFormat
import java.time.LocalDateTime


class DateTimeCommand: BaseCommand() {
    companion object{
        const val COMMANDNAME = "date"
    }
    
    override fun getCommandName(): String {
        return COMMANDNAME
    }

    override fun execute(args: Array<String>, out: OutputStream) {

        val dateFormatter = if (args == null) {
            SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
        } else {
            try {
                SimpleDateFormat(args[0])
            } catch (e: Exception) {
                write(out, "formato inválido")
                return
            }
        }
        val date = LocalDateTime.now()
        write(out, date.toString())
    }
}