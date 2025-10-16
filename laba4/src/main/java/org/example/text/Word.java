package org.example.text;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Представляє окреме слово, що складається з масиву об'єктів {@link Letter}.
 * Цей клас реалізує інтерфейс {@link SentenceComponent}, що дозволяє йому бути частиною речення.
 *
 * @author Onischenko Yevhenii
 */

public class Word implements SentenceComponent {

    /**
     * Список літер, з яких складається слово.
     */
    private final List<Letter> letters;

    /**
     * Конструктор, що створює об'єкт Word з рядка.
     * Кожен символ рядка перетворюється на об'єкт {@link Letter}.
     *
     * @param wordStr Рядок, що представляє слово.
     */
    public Word(String wordStr) {
        this.letters = new ArrayList<>();
        for (char c : wordStr.toCharArray()) {
            this.letters.add(new Letter(c));
        }
    }

    /**
     * Повертає список літер, з яких складається слово.
     *
     * @return Список об'єктів {@link Letter}.
     */
    public List<Letter> getLetters() {
        return letters;
    }

    /**
     * Повертає рядкове представлення слова шляхом об'єднання всіх його літер.
     *
     * @return Рядок, що представляє слово.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters) {
            sb.append(letter.getValue());
        }
        return sb.toString();
    }

    /**
     * Перевіряє рівність двох об'єктів Word.
     * Два слова вважаються рівними, якщо вони складаються з однакової послідовності літер,
     * ігноруючи регістр.
     *
     * @param o Об'єкт для порівняння.
     * @return true, якщо об'єкти рівні, інакше false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word otherWord = (Word) o;
        return this.toString().equalsIgnoreCase(otherWord.toString());
    }

    /**
     * Генерує хеш-код для об'єкта Word на основі його рядкового представлення в нижньому регістрі.
     *
     * @return Хеш-код об'єкта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.toString().toLowerCase());
    }
}
