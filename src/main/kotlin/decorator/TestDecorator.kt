package decorator

fun main(){
    val pine =  PineChristmasTree()
    val christmasTree = BubbleLights(pine)
    val decoratedChristmasTree = Sphere(christmasTree)

    val decorated = BubbleLights( Sphere(PineChristmasTree()))

    println(decoratedChristmasTree.decorate())
    println(decorated.decorate())
}