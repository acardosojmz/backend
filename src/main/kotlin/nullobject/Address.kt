package nullobject

class Address {
    companion object {
        val NULL_ADDRESS = Address("NOT ADDRESS")
    }
    private var fullAddress: String? = null
    constructor(fullAddress: String?) {
        this.fullAddress = fullAddress
    }

    constructor () {
        fullAddress = fullAddress
    }

    fun getFullAddress(): String? {
        return fullAddress
    }

    fun setFullAddress(fullAddress: String?) {
        this.fullAddress = fullAddress
    }
}