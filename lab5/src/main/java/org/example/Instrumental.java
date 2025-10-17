package org.example;

/**
 * A class representing an instrumental composition.
 * It adds a field to specify the main instrument.
 *
 * @author Onischenko Yevhenii
 */
public class Instrumental extends MusicalComposition {
    /** The main instrument featured in the composition. */
    private String mainInstrument;

    /**
     * Constructor for creating an instrumental composition.
     *
     * @param title             The title of the composition.
     * @param artist            The artist.
     * @param durationInSeconds The duration in seconds.
     * @param style             The music style.
     * @param mainInstrument    The main instrument.
     */
    public Instrumental(String title, String artist, int durationInSeconds, String style, String mainInstrument) {
        super(title, artist, durationInSeconds, style);
        this.mainInstrument = mainInstrument;
    }

    public String getMainInstrument() {
        return mainInstrument;
    }

    @Override
    public String toString() {
        return super.toString() + " - [Instrumental: " + mainInstrument + "]";
    }
}