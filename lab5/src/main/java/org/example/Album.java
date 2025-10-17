package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A class representing a music album.
 * It contains a list of musical compositions and methods to manage them.
 *
 * @author Onischenko Yevhenii
 */
public class Album {
    /** The title of the album. */
    private String title;

    /** The list of tracks (compositions) in the album. */
    private List<MusicalComposition> tracks;

    /**
     * Creates a new, empty album with the specified title.
     *
     * @param title The title of the album.
     */
    public Album(String title) {
        this.title = title;
        this.tracks = new ArrayList<>();
    }

    /**
     * Adds a musical composition to the album ("records to disc").
     *
     * @param composition The composition to add.
     * @throws IllegalArgumentException if the provided composition is null.
     */
    public void addComposition(MusicalComposition composition) {
        if (composition == null) {
            throw new IllegalArgumentException("Cannot add a null composition.");
        }
        tracks.add(composition);
    }

    /**
     * Calculates the total duration of all compositions in the album.
     *
     * @return The total duration in seconds.
     */
    public int calculateTotalDuration() {
        return tracks.stream()
                .mapToInt(MusicalComposition::getDurationInSeconds)
                .sum();
    }

    /**
     * Sorts (rearranges) the compositions in the album alphabetically by their style.
     */
    public void sortByStyle() {
        tracks.sort(Comparator.comparing(MusicalComposition::getStyle));
    }

    /**
     * Finds the first composition whose duration falls within the specified range.
     *
     * @param minDuration The lower bound of the range (inclusive), in seconds.
     * @param maxDuration The upper bound of the range (inclusive), in seconds.
     * @return The found musical composition.
     * @throws IllegalArgumentException if the duration range is invalid.
     * @throws CompositionNotFoundException if no composition is found in the specified range.
     */
    public MusicalComposition findCompositionInRange(int minDuration, int maxDuration) throws CompositionNotFoundException {
        if (minDuration < 0 || maxDuration < 0 || minDuration > maxDuration) {
            throw new IllegalArgumentException("Invalid duration range. Bounds cannot be negative, and min cannot exceed max.");
        }

        return tracks.stream()
                .filter(track -> track.getDurationInSeconds() >= minDuration && track.getDurationInSeconds() <= maxDuration)
                .findFirst()
                .orElseThrow(() -> new CompositionNotFoundException(
                        "Composition with a duration between " + minDuration + " and " + maxDuration + " seconds was not found."));
    }

    /**
     * Returns a string representation of the album and its tracklist.
     * @return A string containing information about the album.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Album: '").append(title).append("'\n");
        sb.append("-------------------------------------\n");
        if (tracks.isEmpty()) {
            sb.append("The album is empty.\n");
        } else {
            for (int i = 0; i < tracks.size(); i++) {
                sb.append(i + 1).append(". ").append(tracks.get(i)).append("\n");
            }
        }
        sb.append("-------------------------------------\n");
        return sb.toString();
    }
}