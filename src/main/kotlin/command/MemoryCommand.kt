package command

import java.io.OutputStream

class MemoryCommand: BaseCommand() {
    companion object{
        const val COMMANDNAME = "memory"
    }
    override fun getCommandName(): String {
        return  COMMANDNAME
    }

    override fun execute(args: Array<String>, out: OutputStream) {
        val heap = Runtime.getRuntime().totalMemory() / 1000000.0

        val heapMax = Runtime.getRuntime().maxMemory() / 1000000.0

        val heapFree = Runtime.getRuntime().freeMemory() / 1000000.0

        val output = """
            Heap: $heap
            Max Heap: $heapMax
            Free Heap: $heapFree
            """.trimIndent()
        write(out, output)
    }

}