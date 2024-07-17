package Task3.Controller;

import Task3.Dao.Catalog;
import Task3.Dao.PlaylistComponent;
import Task3.Model.Podcast;
import Task3.Model.Song;
import Task3.Util.SearchStrategy;

import java.util.ArrayList;
import java.util.List;

public class Jukebox {
    private Catalog catalog;
    private SearchStrategy searchStrategy;
    private List<PlaylistComponent> playlists;

    public Jukebox() {
        catalog = Catalog.getInstance();
        searchStrategy = new SearchStrategy();
        playlists = new ArrayList<>();
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

    public PlaylistComponent createPlaylist(String name) {
        PlaylistComponent playlist = new PlaylistComponent(name);
        playlists.add(playlist);
        return playlist;
    }

    public void displayPlaylists() {
        System.out.println("Playlists:");
        for (PlaylistComponent playlist : playlists) {
            playlist.display("  ");
        }
    }
}

