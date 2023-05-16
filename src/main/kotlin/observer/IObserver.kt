package observer

interface IObserver {
    fun notifyObserver(command: String, source: Any)
}