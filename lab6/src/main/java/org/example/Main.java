package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Song extends MusicalComposition {
    public Song(String title, String artist, int durationInSeconds, String style) {
        super(title, artist, durationInSeconds, style);
    }
}

class ClassicalPiece extends MusicalComposition {
    public ClassicalPiece(String title, String artist, int durationInSeconds, String style) {
        super(title, artist, durationInSeconds, style);
    }
}


/**
 * The main class to demonstrate the functionality of the {@link MusicSet} class.
 *
 * @author Onischenko Yevhenii
 */
public class Main {

    public static void main(String[] args) {
        // --- 1. Creating initial data ---
        System.out.println("--- Creating initial compositions ---");
        Song song1 = new Song("Bohemian Rhapsody", "Queen", 355, "Rock");
        Song song2 = new Song("Stairway to Heaven", "Led Zeppelin", 482, "Rock");
        ClassicalPiece piece1 = new ClassicalPiece("The Four Seasons", "Vivaldi", 2520, "Baroque");
        Song duplicateSong = new Song("Bohemian Rhapsody", "Queen", 355, "Progressive Rock");
        System.out.println("Data created.\n");

        // --- 2. Demonstrating constructors ---
        System.out.println("--- Demonstrating constructors ---");

        // Constructor 1: Empty
        Set<MusicalComposition> emptySet = new MusicSet<>();
        System.out.println("1. Created an empty set. Size: " + emptySet.size());

        // Constructor 2: With a single element
        Set<MusicalComposition> singleElementSet = new MusicSet<>(song1);
        System.out.println("2. Created a set with a single element. Size: " + singleElementSet.size());
        System.out.println(singleElementSet);

        // Constructor 3: From an existing collection
        List<MusicalComposition> initialList = new ArrayList<>();
        initialList.add(song2);
        initialList.add(piece1);
        initialList.add(song1); // Adding a duplicate for testing
        Set<MusicalComposition> mainSet = new MusicSet<>(initialList);
        System.out.println("3. Created a set from a List (which contained a duplicate). Size: " + mainSet.size());
        System.out.println(mainSet);

        // --- 3. Demonstrating methods ---
        System.out.println("--- Demonstrating methods ---");

        // The add() method and uniqueness
        System.out.println("Attempting to add a duplicate ('Bohemian Rhapsody')...");
        boolean added = mainSet.add(duplicateSong); // duplicateSong.equals(song1) -> true
        System.out.println("Was the duplicate added? -> " + added);
        System.out.println("Current size: " + mainSet.size() + "\n");

        // The contains() method
        System.out.println("Does the set contain '" + song2.getTitle() + "'? -> " + mainSet.contains(song2));

        // The remove() method
        System.out.println("\nRemoving '" + song2.getTitle() + "'...");
        mainSet.remove(song2);
        System.out.println("Does the set contain '" + song2.getTitle() + "' after removal? -> " + mainSet.contains(song2));
        System.out.println("Collection after removal:");
        System.out.println(mainSet);

        // Iterator (via for-each loop)
        System.out.println("\nIterating through the set elements:");
        for (MusicalComposition composition : mainSet) {
            System.out.println(" -> " + composition.getTitle());
        }

        // The clear() method
        System.out.println("\nClearing the set...");
        mainSet.clear();
        System.out.println("Is the set empty now? -> " + mainSet.isEmpty());
        System.out.println(mainSet);
    }
}