package decorator

abstract class TreeDecorator
(private val tree: IChristmasTree) : IChristmasTree {

    override fun decorate(): String {
        return tree.decorate()
    }
}