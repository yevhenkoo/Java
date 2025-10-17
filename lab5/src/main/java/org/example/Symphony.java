package org.example;

/**
 * A class representing a symphony.
 * It adds a field to store the number of movements.
 *
 * @author Onischenko Yevhenii
 */
public class Symphony extends MusicalComposition {
    /** The number of movements in the symphony. */
    private int numberOfMovements;

    /**
     * Constructor for creating a symphony.
     *
     * @param title             The title.
     * @param artist            The composer.
     * @param durationInSeconds The total duration in seconds.
     * @param style             The style (usually "Classical").
     * @param numberOfMovements The number of movements.
     */
    public Symphony(String title, String artist, int durationInSeconds, String style, int numberOfMovements) {
        super(title, artist, durationInSeconds, style);
        this.numberOfMovements = numberOfMovements;
    }

    public int getNumberOfMovements() {
        return numberOfMovements;
    }

    @Override
    public String toString() {
        return super.toString() + " - [Symphony: " + numberOfMovements + " movements]";
    }
}