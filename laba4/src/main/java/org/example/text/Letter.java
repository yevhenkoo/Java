package org.example.text;

/**
 * Представляє окрему літеру в тексті.
 * Цей клас є найменшою складовою частиною об'єкта {@link Word}.
 *
 * @author Onischenko Yevhenii
 */
public class Letter {
    /**
     * Символ, що зберігається в об'єкті.
     */
    private final char value;

    /**
     * Конструктор для створення об'єкта літери.
     *
     * @param value Символ (char), який представляє літеру.
     */
    public Letter(char value) {
        this.value = value;
    }

    /**
     * Повертає символ, що зберігається в об'єкті.
     *
     * @return Значення літери типу char.
     */
    public char getValue() {
        return value;
    }

    /**
     * Повертає рядкове представлення літери.
     *
     * @return Символ у вигляді рядка.
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * Перевіряє рівність двох об'єктів Letter.
     * Дві літери вважаються рівними, якщо їхні символьні значення однакові.
     *
     * @param o Об'єкт для порівняння.
     * @return true, якщо об'єкти рівні, інакше false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter letter = (Letter) o;
        return value == letter.value;
    }

    /**
     * Генерує хеш-код для об'єкта Letter на основі його символьного значення.
     *
     * @return Хеш-код об'єкта.
     */
    @Override
    public int hashCode() {
        return Character.hashCode(value);
    }
}
