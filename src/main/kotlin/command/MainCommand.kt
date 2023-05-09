package command

import java.util.*


fun main(){

    println("Command Line is Start")
    val manager: CommandManager = CommandManager.getInstance()

    val console = Scanner(System.`in`)

    while (true) {
        val line: String = console.nextLine()
        if (line.trim { it <= ' ' }.isEmpty()) {
            continue
        }
        val commands = CommandUtil.tokenizerArgs(line)
        val commandName = commands[0]
        var commandArgs = arrayOf("")
        if (commands.size > 1) {
            commandArgs = commands.copyOfRange(1, commands.size)
        }
        val command = manager.getCommand(commandName)

        command.execute(commandArgs, System.out)
        println("")
    }


}