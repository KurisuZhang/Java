package Task1.Controller;

import Task1.Dao.Catalog;
import Task1.Model.Song;
import Task1.Util.SearchStrategy;

import java.util.List;

public class Jukebox {
    private Catalog catalog;
    private SearchStrategy searchStrategy;

    public Jukebox() {
        catalog = Catalog.getInstance();
        searchStrategy = new SearchStrategy();
    }

    public void addSong(Song song) {
        catalog.addSong(song);
    }

    public List<Song> getAllSongs() {
        return catalog.getAllSongs();
    }

    public List<Song> search(SearchStrategy.SearchType searchType, String query) {
        return searchStrategy.search(catalog.getAllSongs(), searchType, query);
    }
}


