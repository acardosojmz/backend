package nullobject

class Employee {
    companion object {
        val NULL_EMPLOYEE = Employee(0, "UNKNOWN EMPLOYEE", Address.NULL_ADDRESS)
    }

    private var id=0L
    private var name="UNKNOWN EMPLOYEE"
    private var address=Address.NULL_ADDRESS
    constructor(id: Long, name: String, address: Address) {
        this.id = id
        this.name = name
        this.address = address
    }

    fun getId(): Long {
        return id
    }

    fun setId(id: Long) {
        this.id = id
    }

    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getAddress(): Address {
        return address
    }

    fun setAddress(address: Address) {
        this.address = address
    }
}