package command


class CommandUtil {
    companion object{
        fun tokenizerArgs(args: String): Array<String> {
            return args.split(" ").toTypedArray()
        }
    }
}