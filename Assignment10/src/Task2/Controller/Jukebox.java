package Task2.Controller;

import Task2.Dao.Catalog;
import Task2.Model.Podcast;
import Task2.Model.Song;
import Task2.Util.SearchStrategy;

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

    public void addPodcast(Podcast podcast) {
        catalog.addPodcast(podcast);
    }

    public List<Podcast> getAllPodcasts() {
        return catalog.getAllPodcasts();
    }

    public List<Song> searchSongs(SearchStrategy.SearchType searchType, String query) {
        return searchStrategy.searchSongs(catalog.getAllSongs(), searchType, query);
    }

    public List<Podcast> searchPodcasts(SearchStrategy.SearchType searchType, String query) {
        return searchStrategy.searchPodcasts(catalog.getAllPodcasts(), searchType, query);
    }
}

