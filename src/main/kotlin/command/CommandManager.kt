package command

import java.util.*
import kotlin.reflect.full.createInstance


class CommandManager {
    private val COMMANDS = HashMap<String, Class<out ICommand>>()
    init {
        registerCommand(EchoCommand.COMMANDNAME, EchoCommand::class.java)
        registerCommand(DirCommand.COMMANDNAME, DirCommand::class.java)
        registerCommand(DateTimeCommand.COMMANDNAME, DateTimeCommand::class.java)
        registerCommand(MemoryCommand.COMMANDNAME, MemoryCommand::class.java)
        registerCommand(FileCommand.COMMANDNAME, FileCommand::class.java)
        registerCommand(ExitCommand.COMMANDNAME, ExitCommand::class.java)
        registerCommand(BatchCommand.COMMANDNAME, BatchCommand::class.java)
        registerCommand(Wait.COMMANDNAME, Wait::class.java)
    }
    companion object {

        private lateinit var _commandManager: CommandManager
        fun getInstance(): CommandManager {
            synchronized(this) {
                if (!::_commandManager.isInitialized) {
                    _commandManager = CommandManager()
                }
                return _commandManager
            }
        }
    }

    private fun registerCommand(commandName: String, command: Class<out ICommand>) {
        COMMANDS[commandName.uppercase()] = command
    }
    fun getCommand(commandName: String): ICommand {
        return if (COMMANDS.containsKey(commandName.uppercase())) {
            try {
                val className=  COMMANDS[commandName.uppercase()].toString().replace("class","").trim()
                Class.forName(className).kotlin.createInstance() as ICommand
            } catch (e: Exception) {
                e.printStackTrace()
                ErrorCommand()
            }
        } else {
            NotFoundCommand()
        }
    }
}