package decorator



class Sphere(tree: IChristmasTree) : TreeDecorator(tree) {

    override fun decorate(): String {
        return super.decorate() + decorateWithSpheres()
    }

    private fun decorateWithSpheres(): String {
        return " with spheres"
    }
}