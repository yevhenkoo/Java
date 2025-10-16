package org.example.text;

/**
 * Представляє окремий розділовий знак у реченні.
 *
 * @author Onischenko Yevhenii
 */
public class Punctuation implements SentenceComponent {
    /**
     * Символ, що представляє розділовий знак.
     */
    private final char value;

    /**
     * Конструктор для створення об'єкта розділового знака.
     *
     * @param value Символ (char), який представляє розділовий знак.
     */
    public Punctuation(char value) {
        this.value = value;
    }

    /**
     * Повертає символ розділового знака.
     *
     * @return Значення розділового знака типу char.
     */
    public char getValue() {
        return value;
    }

    /**
     * Повертає рядкове представлення розділового знака.
     *
     * @return Символ у вигляді рядка.
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
