package memento

import java.util.*


class EmployeeCaretaker {
    private var currentIndex = -1
    private val states = LinkedList<EmployeeMemento>()
    fun addNewMemento(m: EmployeeMemento) {
        states.add(m)
        currentIndex++
    }

    fun getCurrentMemento(): EmployeeMemento {
        return states[currentIndex]
    }

    fun getNextMemento(): EmployeeMemento? {
        val newIndex = currentIndex + 1
        if (newIndex >= states.size) {
            return null
        }
        currentIndex = newIndex
        return states[currentIndex]
    }

    fun getPreviousMemento(): EmployeeMemento? {
        val newIndex = currentIndex - 1
        if (newIndex <= -1 || newIndex >= states.size - 1) {
            return null
        }
        currentIndex = newIndex
        return states[currentIndex]
    }
}