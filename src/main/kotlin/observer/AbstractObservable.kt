package observer


abstract class AbstractObservable: IObservable {
    private val observers: ArrayList<IObserver> = ArrayList()
    override fun notifyAllObservers(command: String, source: Any) {
        observers.forEach {
            it.notifyObserver(command, source)
        }
    }

    override fun addObserver(observer: IObserver) {
        observers.add(observer)
    }

    override fun removeObserver(observer: IObserver) {
        observers.remove(observer)
    }
}