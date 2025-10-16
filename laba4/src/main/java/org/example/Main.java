package org.example;


import org.example.text.Text;
import org.example.text.Word;

public class Main {

    /**
     * Головний виконавчий метод програми.
     * Створює текст, обробляє його та виводить результат.
     *
     * @param args Аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        // Вхідний текст
        String inputText = """
                Java is a popular programming language.
                I love programming in Java!
                The Java language is used for developing applications.
                Programming helps improve logic skills.
                Java allows creating high-performance programs.
                My first program in Java was simple.
                People all over the world learn Java.
                Programming in Java is fun and useful.
                Java is one of the most popular programming languages.
                I always recommend starting with learning Java.""";

        // 1. Створення об'єкта Text з вхідного рядка
        Text text = new Text(inputText);

        // 2. Створення процесора та виконання аналізу
        TextProcessor processor = new TextProcessor();
        Word mostFrequentWord = processor.findMostFrequentWordInSentences(text);

        // 3. Відображення результатів
        if (mostFrequentWord != null) {
            long maxSentenceCount = text.getSentences().stream()
                    .filter(sentence -> sentence.getWords().contains(mostFrequentWord))
                    .count();

            System.out.println("The word '" + mostFrequentWord + "' appears in the largest number of sentences.");
            System.out.println("Number of sentences: " + maxSentenceCount);
        }
        else {
            System.out.println("The text does not contain any words for analysis.");

        }
    }
}