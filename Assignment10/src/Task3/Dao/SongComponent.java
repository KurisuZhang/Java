package Task3.Dao;

import Task3.Model.Song;
import Task3.Model.PlaylistInterface;

import java.util.Collections;
import java.util.List;

public class SongComponent implements PlaylistInterface {
    private Song song;

    public SongComponent(Song song) {
        this.song = song;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "- Song: " + song.getTitle() + " - " + song.getArtist());
    }
}

