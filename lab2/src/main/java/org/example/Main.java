package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Input text
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
        StringBuffer textBuffer = new StringBuffer(inputText);

        //Split text into sentences
        List<StringBuffer> sentences = getSentences(textBuffer);

        if (sentences.isEmpty()) {
            System.out.println("The text does not contain any sentences.");
            return;
        }

        //Get all unique words from the text
        List<StringBuffer> uniqueWords = getUniqueWords(sentences);

        int maxSentenceCount = 0;
        StringBuffer mostFrequentWord = new StringBuffer();

        //Count in how many sentences each word appears
        for (StringBuffer word : uniqueWords) {
            int currentSentenceCount = 0;
            for (StringBuffer sentence : sentences) {
                if (sentenceContainsWord(sentence, word)) {
                    currentSentenceCount++;
                }
            }
            //Update maximum counter
            if (currentSentenceCount > maxSentenceCount) {
                maxSentenceCount = currentSentenceCount;
                mostFrequentWord = word;
            }
        }

        //Display results
        System.out.println("The word '" + mostFrequentWord.toString() + "' appears in the most sentences.");
        System.out.println("Number of sentences: " + maxSentenceCount);
    }


    //Splits text into a list of sentences.

    private static List<StringBuffer> getSentences(StringBuffer text) {
        List<StringBuffer> sentences = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '.' || c == '?' || c == '!') {
                if (i > start) {
                    sentences.add(new StringBuffer(text.substring(start, i).trim()));
                }
                start = i + 1;
            }
        }
        if (start < text.length()) { // Add last sentence if no punctuation
            sentences.add(new StringBuffer(text.substring(start).trim()));
        }
        return sentences;
    }

    //Splits a sentence into a list of words.
    private static List<StringBuffer> getWords(StringBuffer sentence) {
        List<StringBuffer> words = new ArrayList<>();
        int start = 0;
        // Convert sentence to lowercase for consistent comparison
        StringBuffer lowerCaseSentence = new StringBuffer(sentence.toString().toLowerCase());

        for (int i = 0; i < lowerCaseSentence.length(); i++) {
            char c = lowerCaseSentence.charAt(i);
            // Delimiters are spaces and punctuation
            if (!Character.isLetterOrDigit(c)) {
                if (start < i) {
                    words.add(new StringBuffer(lowerCaseSentence.substring(start, i)));
                }
                start = i + 1;
            }
        }
        if (start < lowerCaseSentence.length()) {
            words.add(new StringBuffer(lowerCaseSentence.substring(start)));
        }
        return words;
    }


    //Collects all unique words from all sentences.
    private static List<StringBuffer> getUniqueWords(List<StringBuffer> sentences) {
        List<StringBuffer> allWords = new ArrayList<>();
        List<StringBuffer> uniqueWords = new ArrayList<>();

        // Gather all words
        for (StringBuffer sentence : sentences) {
            allWords.addAll(getWords(sentence));
        }

        // Keep only unique words
        for (StringBuffer word : allWords) {
            boolean isUnique = true;
            for (StringBuffer uniqueWord : uniqueWords) {
                if (areStringBuffersEqual(word, uniqueWord)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueWords.add(word);
            }
        }
        return uniqueWords;
    }

    //Checks if a sentence contains a specific word.
    private static boolean sentenceContainsWord(StringBuffer sentence, StringBuffer wordToFind) {
        List<StringBuffer> wordsInSentence = getWords(sentence);
        for (StringBuffer word : wordsInSentence) {
            if (areStringBuffersEqual(word, wordToFind)) {
                return true;
            }
        }
        return false;
    }

    //Compares two StringBuffers for equality.
    private static boolean areStringBuffersEqual(StringBuffer sb1, StringBuffer sb2) {
        if (sb1 == null || sb2 == null || sb1.length() != sb2.length()) {
            return false;
        }
        for (int i = 0; i < sb1.length(); i++) {
            if (sb1.charAt(i) != sb2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
