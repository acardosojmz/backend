package strategy


class OnMemoryDataBase {
    companion object {
        private val users=hashMapOf("Ambrosio" to User("Ambrosio","123456","Admin"),
            "Cardoso" to User("Cardoso","123456","Docente"),
            "Jimenez" to User("Jimenez","123456","Estudiante"),
        )
        fun findUserByName(name: String?): User? {
            return users[name]
        }
    }
}