package Task1.Controller;

import Task1.Util.SearchStrategy;
import Task1.Util.SongFactory;

public class Main {
    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();

        // Adding songs to the jukebox
        jukebox.addSong(SongFactory.createSong("Song5", "Artist1", "Rock", "Album1"));
        jukebox.addSong(SongFactory.createSong("Song2", "Artist2", "Pop", "Album2"));
        jukebox.addSong(SongFactory.createSong("Song3", "Artist1", "Rock", "Album3"));
        jukebox.addSong(SongFactory.createSong("Song4", "Artist3", "Jazz", "Album4"));
        jukebox.addSong(SongFactory.createSong("Song1", "Artist3", "Pop", "Album6"));

        System.out.println("================Task1================");
        // Display all songs
        System.out.println("All Songs:");
        jukebox.getAllSongs().forEach(System.out::println);

        // Search by artist
        System.out.println("\nSongs by Artist1:");
        jukebox.search(SearchStrategy.SearchType.ARTIST, "Artist1").forEach(System.out::println);

        // Search by genre
        System.out.println("\nRock Songs:");
        jukebox.search(SearchStrategy.SearchType.GENRE, "Rock").forEach(System.out::println);

        // Search by album
        System.out.println("\nSongs in Album2:");
        jukebox.search(SearchStrategy.SearchType.ALBUM, "Album2").forEach(System.out::println);
    }
}


