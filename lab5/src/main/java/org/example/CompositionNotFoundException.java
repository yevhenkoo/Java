package org.example;

/**
 * A specialized exception that is thrown when a composition
 * with the specified criteria is not found in the album.
 *
 * @author Onischenko Yevhenii
 */
public class CompositionNotFoundException extends Exception {
    /**
     * Constructs the exception with a detail message.
     *
     * @param message The error message.
     */
    public CompositionNotFoundException(String message) {
        super(message);
    }
}