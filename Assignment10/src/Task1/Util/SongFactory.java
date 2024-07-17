package Task1.Util;

import Task1.Model.Song;

public class SongFactory {
    public static Song createSong(String title, String artist, String genre, String album) {
        return new Song(title, artist, genre, album);
    }
}

