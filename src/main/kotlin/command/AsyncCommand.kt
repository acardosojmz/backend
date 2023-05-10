package command

import java.io.OutputStream

abstract class AsyncCommand: BaseCommand() {

    override fun execute(args: Array<String>, out: OutputStream) {
        Thread( Runnable() {

            fun run() {

                executeOnBackground(args, out)

            }

        }).start()

    }

    abstract fun  executeOnBackground(args: Array<String>,  out:OutputStream)


}