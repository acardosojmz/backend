package decorator

class BubbleLights(tree: IChristmasTree) : TreeDecorator(tree) {

    override fun decorate(): String {
        return super.decorate() + decorateWithBubbleLights()
    }

    private fun decorateWithBubbleLights(): String {
        return " with Bubble Lights"
    }
}