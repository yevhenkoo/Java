package org.example.text;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Представляє речення, що складається з масиву слів ({@link Word}) та розділових знаків ({@link Punctuation}).
 *
 * @author Onischenko Yevhenii
 */
public class Sentence {

    /**
     * Список компонентів речення (слів та розділових знаків).
     */
    private final List<SentenceComponent> components;

    /**
     * Конструктор, що створює об'єкт Sentence з рядка.
     * Рядок розбивається на слова та розділові знаки, які зберігаються як об'єкти.
     *
     * @param sentenceStr Рядок, що представляє речення.
     */
    public Sentence(String sentenceStr) {
        this.components = new ArrayList<>();
        // Використовуємо регулярний вираз для розділення на слова та розділові знаки
        String[] tokens = sentenceStr.trim().split("(?=[.,!?])|\\s+");

        for (String token : tokens) {
            if (token.isEmpty()) continue;

            if (token.matches("[a-zA-Z0-9]+")) {
                components.add(new Word(token));
            } else if (token.length() == 1 && ",.?!".contains(token)) {
                components.add(new Punctuation(token.charAt(0)));
            } else {
                // Для складніших випадків, де слово може містити дефіс або апостроф
                components.add(new Word(token));
            }
        }
    }

    /**
     * Повертає список компонентів, з яких складається речення.
     *
     * @return Список об'єктів, що реалізують {@link SentenceComponent}.
     */
    public List<SentenceComponent> getComponents() {
        return components;
    }

    /**
     * Повертає тільки слова, що містяться в реченні.
     *
     * @return Список об'єктів {@link Word}.
     */
    public List<Word> getWords() {
        return components.stream()
                .filter(c -> c instanceof Word)
                .map(c -> (Word) c)
                .collect(Collectors.toList());
    }

    /**
     * Повертає рядкове представлення речення, відновлюючи пробіли та розділові знаки.
     *
     * @return Рядок, що представляє речення.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < components.size(); i++) {
            SentenceComponent current = components.get(i);
            sb.append(current.toString());

            // Додаємо пробіл, якщо поточний компонент є словом і наступний компонент також є словом.
            if (i < components.size() - 1) {
                SentenceComponent next = components.get(i + 1);
                if (current instanceof Word && next instanceof Word) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}