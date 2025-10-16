package org.example.text;

import java.util.ArrayList;
import java.util.List;

/**
 * Представляє текст, що складається з масиву речень ({@link Sentence}).
 *
 * @author Onischenko Yevhenii
 */
public class Text {

    /**
     * Список речень, з яких складається текст.
     */
    private final List<Sentence> sentences;

    /**
     * Конструктор, що створює об'єкт Text з вхідного рядка.
     * Текст нормалізується (видаляються зайві пробіли та табуляції) і розбивається на речення.
     *
     * @param textStr Вхідний рядок з текстом.
     */
    public Text(String textStr) {
        this.sentences = new ArrayList<>();
        // 1. Замінити послідовність табуляцій та пробілів одним пробілом.
        String normalizedText = textStr.replaceAll("[\\t ]+", " ").trim();

        // 2. Розділити текст на речення за допомогою регулярного виразу
        // Роздільник - це крапка, знак питання або оклику, за яким йде пробіл або кінець рядка.
        String[] sentenceStrings = normalizedText.split("(?<=[.?!])\\s*");

        for (String sStr : sentenceStrings) {
            if (!sStr.isBlank()) {
                this.sentences.add(new Sentence(sStr));
            }
        }
    }

    /**
     * Повертає список речень, з яких складається текст.
     *
     * @return Список об'єктів {@link Sentence}.
     */
    public List<Sentence> getSentences() {
        return sentences;
    }

    /**
     * Повертає рядкове представлення повного тексту.
     *
     * @return Рядок, що представляє весь текст.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append(sentence.toString()).append(" ");
        }
        return sb.toString().trim();
    }
}
