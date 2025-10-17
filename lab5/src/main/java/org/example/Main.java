package org.example;

/**
 * A demonstration class to test the functionality of the music hierarchy.
 *
 * @author Onischenko Yevhenii
 */
public class Main {
    public static void main(String[] args) {
        // 1. Create an album
        Album myAlbum = new Album("Greatest Hits");

        // 2. Create and add compositions ("Record to disc")
        try {
            myAlbum.addComposition(new Song("Bohemian Rhapsody", "Queen", 355, "Rock", "Is this the real life?..."));
            myAlbum.addComposition(new Instrumental("Orion", "Metallica", 507, "Metal", "Electric Guitar"));
            myAlbum.addComposition(new Song("Stairway to Heaven", "Led Zeppelin", 482, "Rock", "There's a lady who's sure..."));
            myAlbum.addComposition(new Symphony("Symphony No. 5", "Beethoven", 2100, "Classical", 4));
            myAlbum.addComposition(new Instrumental("Clair de Lune", "Claude Debussy", 303, "Classical", "Piano"));
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding composition: " + e.getMessage());
        }

        System.out.println("--- Initial Album State ---");
        System.out.println(myAlbum);

        // 3. Calculate total duration
        int totalSeconds = myAlbum.calculateTotalDuration();
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        System.out.printf("Total album duration: %d minutes %d seconds (%d seconds)\n\n", minutes, seconds, totalSeconds);

        // 4. Rearrange compositions by style
        System.out.println("--- Sorting Album by Style ---");
        myAlbum.sortByStyle();
        System.out.println(myAlbum);

        // 5. Find a composition in a duration range
        System.out.println("--- Searching for a composition between 300 and 360 seconds ---");
        try {
            MusicalComposition found = myAlbum.findCompositionInRange(300, 360);
            System.out.println("Found composition: " + found);
        } catch (CompositionNotFoundException | IllegalArgumentException e) {
            System.err.println("Search error: " + e.getMessage());
        }
        System.out.println();

        // 6. Demonstrate exception handling
        System.out.println("--- Exception Handling Demonstration ---");

        // Attempt to find a track that doesn't exist
        System.out.println("Attempting to find a track from 0 to 100 seconds:");
        try {
            myAlbum.findCompositionInRange(0, 100);
        } catch (CompositionNotFoundException | IllegalArgumentException e) {
            System.err.println("Expected error: " + e.getMessage());
        }

        // Attempt to search with an invalid range
        System.out.println("\nAttempting to search with an invalid range (500, 400):");
        try {
            myAlbum.findCompositionInRange(500, 400);
        } catch (CompositionNotFoundException | IllegalArgumentException e) {
            System.err.println("Expected error: " + e.getMessage());
        }

        // Attempt to add a null composition
        System.out.println("\nAttempting to add null to the album:");
        try {
            myAlbum.addComposition(null);
        } catch (IllegalArgumentException e) {
            System.err.println("Expected error: " + e.getMessage());
        }
    }
}