package org.example;


import java.util.Arrays;

/**
 * Main class demonstrating sorting and searching for {@link SportEquipment} objects.
 *
 * This class initializes an array of sports equipment, sorts it by two criteria
 * (name and price), and performs a linear search to find a specific element.
 */
public class Main {
    public static void main(String[] args) {
        /**
         * The entry point of the program.
         * <p>
         * The method performs the following actions:
         * <ol>
         * <li>Creates an array of {@code SportEquipment} objects.</li>
         * <li>Sorts the array using a custom comparator: first by name
         * in alphabetical order, and then by price in descending order.</li>
         * <li>Prints the sorted array to the console.</li>
         * <li>Performs a search for a given object in the array and prints the result.</li>
         * </ol>
         *
         * @param args Command-line arguments (not used).
         */
        SportEquipment[] items = {
                new SportEquipment("Basketball", "Team Sport", 0.45, 30, 5),
                new SportEquipment("Basketball", "Team Sport", 0.62, 25, 10),
                new SportEquipment("Dumbbell", "Strength", 5.0, 50, 15),
                new SportEquipment("Treadmill", "Cardio", 80.0, 500, 2),
                new SportEquipment("Yoga Mat", "Flexibility", 1.2, 20, 8)
        };
        Arrays.sort(items, (a, b) -> {
            int typeCompare = a.getName().compareTo(b.getName());
            if (typeCompare != 0) {
                return typeCompare; // ascending order by name
            }
            return Double.compare(b.getPrice(), a.getPrice()); // descending order by price
        });

        /**Print sorted array*/
        System.out.println("Sorted array:");
        for (SportEquipment item : items) {
            System.out.println(item);
        }

        /**Search for a given object*/
        SportEquipment target = new SportEquipment("Basketball", "Team Sport", 0.62, 25, 10);

        boolean found = false;
        for (SportEquipment item : items) {
            if (item.equals(target)) {
                System.out.println("Found object: " + item);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Object not found.");
        }
    }
}