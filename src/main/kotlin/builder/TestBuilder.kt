package builder

fun main(){
    val employee = Employee.Builder()
        .setName("Lucia Perez Perez")
        .setGender("Female")
        .setAge(30)
        .setAddress("Aragón 189 int 404 col. Álamos, delegación Benito "
                + "Juarez", "México D.F.", "México", "03400")
        .addContacts("Juan Perez", "1122334455", "123", "Casa",
            "Chapultepect No. 123 Col. Militar", "México"
            , "México", "10023")
        .addContacts("Rocio Perez", "3344556677", null, "Celular")
        .addPhones("4567890234", null, "Celular")
        .addPhones("7788990099", null, "Casa")
        .build()
    println(employee)
}
