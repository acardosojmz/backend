package flyweight

class PlayList (private val playListName: String) {
    private var playItems= ArrayList<PlayItem?>()
    fun addPlayItem(songName: String){
        playItems.add(PlayItemFactory.createPlayItems(songName));
    }

    fun printList(){
        var out = "\nPlayList > $playListName"
        for (playItem in playItems) {
            out += "\n\t" + playItem.toString()
        }
        println(out)
    }
}