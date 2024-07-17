package Task1.Dao;

import Task1.Model.Song;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private static Catalog instance;
    private List<Song> songs;

    private Catalog() {
        songs = new ArrayList<>();
    }

    public static Catalog getInstance() {
        if (instance == null) {
            instance = new Catalog();
        }
        return instance;
    }

    public void addSong(Song song) {
        songs.add(song);
        songs.sort((s1, s2) -> s1.getTitle().compareTo(s2.getTitle()));
    }

    public List<Song> getAllSongs() {
        return new ArrayList<>(songs);
    }
}

