package builder

data class Employee( private val name: String?,
                     private val age: Int =0,
                     private val gender: String?,
                     private val address: Address?,
                     private val phones: List<Phone>?,
                     private val contacts: List<Contact>?){
        constructor(name: String, age: Int, gender: String ) :
                this(name = name, age = age,gender = gender, address=null,phones = null,contacts=null) {

        }
    class Builder : IBuilder<Employee> {
        private var name: String? = null
        private var age = 0
        private var gender: String? = null
        private var address: Address? = null
        private val phones: MutableList<Phone> = ArrayList<Phone>()
        private val contacts: MutableList<Contact> = ArrayList<Contact>()
        fun setName(name: String?): Builder {
            this.name = name
            return this
        }

        fun setAge(age: Int): Builder {
            this.age = age
            return this
        }

        fun setGender(gender: String?): Builder {
            this.gender = gender
            return this
        }

        fun setAddress(
            address: String?, city: String?,
            country: String?, cp: String?
        ): Builder {
            this.address = Address(address, city, country, cp)
            return this
        }

        fun addPhones(
            phoneNumber: String?, ext: String?,
            phoneType: String?
        ): Builder {
            phones.add(Phone(phoneNumber, ext, phoneType))
            return this
        }

        fun addContacts(
            name: String?, phoneNumber: String?,
            ext: String?, phoneType: String?, address: String?, city: String?,
            country: String?, cp: String?
        ): Builder {
            contacts.add(
                Contact(
                    name, Phone(phoneNumber, ext, phoneType), Address(address, city, country, cp)
                )
            )
            return this
        }

        fun addContacts(
            name: String?, phoneNumber: String?,
            ext: String?, phoneType: String?
        ): Builder {
            contacts.add(Contact(name=name, phone =  Phone(phoneNumber, ext, phoneType), address = null))
            return this
        }

        override fun build(): Employee {
            return Employee(name, age, gender, address, phones, contacts = contacts)
        }

    }
}
