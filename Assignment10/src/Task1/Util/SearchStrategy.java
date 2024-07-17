package Task1.Util;

import Task1.Model.Song;

import java.util.List;
import java.util.stream.Collectors;

public class SearchStrategy {
    public enum SearchType {
        ARTIST, GENRE, ALBUM
    }

    public List<Song> search(List<Song> songs, SearchType searchType, String query) {
        switch (searchType) {
            case ARTIST:
                return songs.stream()
                        .filter(song -> song.getArtist().equalsIgnoreCase(query))
                        .collect(Collectors.toList());
            case GENRE:
                return songs.stream()
                        .filter(song -> song.getGenre().equalsIgnoreCase(query))
                        .collect(Collectors.toList());
            case ALBUM:
                return songs.stream()
                        .filter(song -> song.getAlbum().equalsIgnoreCase(query))
                        .collect(Collectors.toList());
            default:
                throw new IllegalArgumentException("Unknown search type: " + searchType);
        }
    }
}


