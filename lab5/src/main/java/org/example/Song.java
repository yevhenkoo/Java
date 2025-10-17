package org.example;

/**
 * A class representing a song, which is a type of musical composition.
 * It adds a field for storing the song's lyrics.
 *
 * @author Onischenko Yevhenii
 */
public class Song extends MusicalComposition {
    /** The lyrics of the song. */
    private String lyrics;

    /**
     * Constructor for creating a Song object.
     *
     * @param title             The title of the song.
     * @param artist            The artist.
     * @param durationInSeconds The duration in seconds.
     * @param style             The music style.
     * @param lyrics            The lyrics of the song.
     */
    public Song(String title, String artist, int durationInSeconds, String style, String lyrics) {
        super(title, artist, durationInSeconds, style);
        this.lyrics = lyrics;
    }

    public String getLyrics() {
        return lyrics;
    }

    @Override
    public String toString() {
        return super.toString() + " - [Song]";
    }
}