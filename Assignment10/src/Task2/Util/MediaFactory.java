package Task2.Util;

import Task2.Model.Podcast;
import Task2.Model.Song;

import java.time.LocalDate;

public class MediaFactory {
    public static Song createSong(String title, String artist, String genre, String album) {
        return new Song(title, artist, genre, album);
    }

    public static Podcast createPodcast(String title, String celebrity, LocalDate publishDate) {
        return new Podcast(title, celebrity, publishDate);
    }
}

