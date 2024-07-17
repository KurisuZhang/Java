package Task3.Controller;

import Task3.Util.SearchStrategy;
import Task3.Dao.PlaylistComponent;
import Task3.Dao.PodcastComponent;
import Task3.Dao.SongComponent;
import Task3.Util.MediaFactory;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();

        // Adding songs to the jukebox
        jukebox.addSong(MediaFactory.createSong("Song5", "Artist1", "Rock", "Album1"));
        jukebox.addSong(MediaFactory.createSong("Song2", "Artist2", "Pop", "Album2"));
        jukebox.addSong(MediaFactory.createSong("Song3", "Artist1", "Rock", "Album3"));
        jukebox.addSong(MediaFactory.createSong("Song4", "Artist3", "Jazz", "Album4"));
        jukebox.addSong(MediaFactory.createSong("Song1", "Artist3", "Pop", "Album6"));

        // Adding podcasts to the jukebox
        jukebox.addPodcast(MediaFactory.createPodcast("Podcast1", "Celebrity1", LocalDate.of(2023, 7, 1)));
        jukebox.addPodcast(MediaFactory.createPodcast("Podcast2", "Celebrity2", LocalDate.of(2023, 7, 2)));
        jukebox.addPodcast(MediaFactory.createPodcast("Podcast3", "Celebrity1", LocalDate.of(2023, 7, 3)));

        System.out.println("================Task1================");
        // Display all songs
        System.out.println("All Songs:");
        jukebox.getAllSongs().forEach(System.out::println);
        // Search by artist
        System.out.println("\nSongs by Artist1:");
        jukebox.searchSongs(SearchStrategy.SearchType.SONG_ARTIST, "Artist1").forEach(System.out::println);
        // Search by genre
        System.out.println("\nRock Songs:");
        jukebox.searchSongs(SearchStrategy.SearchType.SONG_GENRE, "Rock").forEach(System.out::println);
        // Search by album
        System.out.println("\nSongs in Album2:");
        jukebox.searchSongs(SearchStrategy.SearchType.SONG_ALBUM, "Album2").forEach(System.out::println);
        System.out.println("================Task2================");
        // Display all podcasts
        System.out.println("\nAll Podcasts:");
        jukebox.getAllPodcasts().forEach(System.out::println);
        // Search podcasts by celebrity
        System.out.println("\nPodcasts by Celebrity1:");
        jukebox.searchPodcasts(SearchStrategy.SearchType.PODCAST_CELEBRITY, "Celebrity1").forEach(System.out::println);
        // Search podcasts by date
        System.out.println("\nPodcasts published on 2023-07-02:");
        jukebox.searchPodcasts(SearchStrategy.SearchType.PODCAST_DATE, "2023-07-02").forEach(System.out::println);

        System.out.println("================Task3================\n");
        // Create a playlist
        PlaylistComponent playlist1 = jukebox.createPlaylist("My Playlist1");
        PlaylistComponent playlist2 = jukebox.createPlaylist("My Playlist2");
        // Add songs to the playlist
        playlist1.add(new SongComponent(MediaFactory.createSong("Song1", "Artist1", "Rock", "Album1")));
        playlist1.add(new SongComponent(MediaFactory.createSong("Song2", "Artist2", "Pop", "Album2")));
        playlist1.add(new SongComponent(MediaFactory.createSong("Song3", "Artist1", "Rock", "Album3")));
        playlist2.add(new SongComponent(MediaFactory.createSong("Song4", "Artist2", "Pop", "Album4")));
        // Add a podcast to the playlist
        playlist1.add(new PodcastComponent(MediaFactory.createPodcast("Podcast1", "Celebrity1", LocalDate.of(2023, 7, 1))));
        playlist2.add(new PodcastComponent(MediaFactory.createPodcast("Podcast2", "Celebrity2", LocalDate.of(2024, 7, 1))));

        // Display all playlists
        jukebox.displayPlaylists();
    }
}

