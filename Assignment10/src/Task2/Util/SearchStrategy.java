package Task2.Util;

import Task2.Model.Podcast;
import Task2.Model.Song;

import java.util.List;
import java.util.stream.Collectors;

public class SearchStrategy {
    public enum SearchType {
        SONG_ARTIST, SONG_GENRE, SONG_ALBUM, PODCAST_CELEBRITY, PODCAST_DATE
    }

    public List<Song> searchSongs(List<Song> songs, SearchType searchType, String query) {
        switch (searchType) {
            case SONG_ARTIST:
                return songs.stream()
                        .filter(song -> song.getArtist().equalsIgnoreCase(query))
                        .collect(Collectors.toList());
            case SONG_GENRE:
                return songs.stream()
                        .filter(song -> song.getGenre().equalsIgnoreCase(query))
                        .collect(Collectors.toList());
            case SONG_ALBUM:
                return songs.stream()
                        .filter(song -> song.getAlbum().equalsIgnoreCase(query))
                        .collect(Collectors.toList());
            default:
                throw new IllegalArgumentException("Unknown search type for songs: " + searchType);
        }
    }

    public List<Podcast> searchPodcasts(List<Podcast> podcasts, SearchType searchType, String query) {
        switch (searchType) {
            case PODCAST_CELEBRITY:
                return podcasts.stream()
                        .filter(podcast -> podcast.getCelebrity().equalsIgnoreCase(query))
                        .collect(Collectors.toList());
            case PODCAST_DATE:
                return podcasts.stream()
                        .filter(podcast -> podcast.getPublishDate().toString().equals(query))
                        .collect(Collectors.toList());
            default:
                throw new IllegalArgumentException("Unknown search type for podcasts: " + searchType);
        }
    }
}

