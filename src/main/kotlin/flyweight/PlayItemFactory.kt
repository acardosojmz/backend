package flyweight


class PlayItemFactory {
    companion object {
        private const val enableFlyweight = true
        private val playItems  = hashMapOf<String,PlayItem>()
        private var idSequence = 0L

        fun createPlayItems(songName: String): PlayItem? {
            return if(enableFlyweight && playItems.containsKey(songName)) {
                playItems[songName]
            } else {
                val playItem = PlayItem(++idSequence, songName)
                playItems[songName] = playItem
                playItem
            }
        }
     }
}