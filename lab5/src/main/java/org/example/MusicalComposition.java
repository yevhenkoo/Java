package org.example;

/**
 * Abstract base class representing a general musical composition.
 * It defines the core properties common to any piece of music.
 *
 * @author Onischenko Yevhenii
 */
public abstract class MusicalComposition {
    /** The title of the composition. */
    protected String title;

    /** The artist or composer of the composition. */
    protected String artist;

    /** The duration of the composition in seconds. */
    protected int durationInSeconds;

    /** The musical style of the composition. */
    protected String style;

    /**
     * Constructor for creating a musical composition.
     *
     * @param title             The title of the composition.
     * @param artist            The artist of the composition.
     * @param durationInSeconds The duration in seconds.
     * @param style             The style of the composition.
     */
    public MusicalComposition(String title, String artist, int durationInSeconds, String style) {
        this.title = title;
        this.artist = artist;
        this.durationInSeconds = durationInSeconds;
        this.style = style;
    }

    // --- Getters for field access ---

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public String getStyle() {
        return style;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string with information about the composition.
     */
    @Override
    public String toString() {
        int minutes = durationInSeconds / 60;
        int seconds = durationInSeconds % 60;
        return String.format("'%s' - %s (%s) [%d:%02d]", title, artist, style, minutes, seconds);
    }
}
