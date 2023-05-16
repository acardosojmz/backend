package templatemethod

import java.io.File

fun main(){
    val logDir = "/home/ambrosio/templatemethod/logs"
    val processDir = "/home/ambrosio/templatemethod/process"
    val files = arrayOf("/home/ambrosio/templatemethod/abc.drug",
        "/home/ambrosio/templatemethod/123.grys" )
    println("> Monitoring start")

    val fileDrug = File(files[0])

    DrugstoreFileProcess(fileDrug, logDir, processDir).execute()

    println("File processed  > " + fileDrug.name)

    val fileGry = File(files[1])
    GroceryFileProcess(fileGry, logDir, processDir).execute()
    println("File processed  > " + fileGry.name)

}