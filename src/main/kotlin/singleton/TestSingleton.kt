package singleton

fun main (){
    var singletonA: Singleton? = Singleton.getInstance()

    var singletonB: Singleton? = Singleton.getInstance()

    println(singletonA)

    println(singletonB)

    println("Misma referencia ==> " + (singletonA === singletonB))

    singletonA?.setAppName("Singleton Pattern")

    singletonB?.setAppVersion("1.0")

    println("SingletonA ==> $singletonA")

    println("SingletonB ==> $singletonB")

    singletonA = null

    singletonB = null

    singletonA = Singleton.getInstance()

    println("SingletonA ==> $singletonA")
}
