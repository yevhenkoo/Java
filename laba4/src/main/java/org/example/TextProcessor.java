package org.example;

import org.example.text.Sentence;
import org.example.text.Text;
import org.example.text.Word;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Клас для обробки тексту, що містить виконавчий метод для аналізу.
 * Виконує завдання з пошуку слова, яке зустрічається в найбільшій кількості речень.
 *
 * @author Onischenko Yevhenii
 */
public class TextProcessor {

    /**
     * Знаходить слово, яке зустрічається в найбільшій кількості речень тексту.
     *
     * @param text Об'єкт {@link Text} для аналізу.
     * @return Об'єкт {@link Word}, що є найчастішим, або {@code null}, якщо текст порожній.
     */
    public Word findMostFrequentWordInSentences(Text text) {
        if (text == null || text.getSentences().isEmpty()) {
            return null;
        }

        // Крок 1: Зібрати всі унікальні слова з усього тексту
        Set<Word> uniqueWords = text.getSentences().stream()
                .flatMap(sentence -> sentence.getWords().stream())
                .collect(Collectors.toSet());

        // Крок 2: Створити мапу для підрахунку, в скількох реченнях зустрічається кожне слово
        Map<Word, Integer> wordSentenceCount = new HashMap<>();

        for (Word uniqueWord : uniqueWords) {
            int count = 0;
            for (Sentence sentence : text.getSentences()) {
                // Перевіряємо, чи містить речення це слово (використовує перевантажений equals)
                if (sentence.getWords().contains(uniqueWord)) {
                    count++;
                }
            }
            wordSentenceCount.put(uniqueWord, count);
        }

        // Крок 3: Знайти слово з максимальним лічильником
        return Collections.max(wordSentenceCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}