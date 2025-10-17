package org.example;

import java.util.Iterator;

/**
 * Узагальнений інтерфейс для простої колекції.
 * Визначає основні операції, які повинна підтримувати музична колекція.
 *
 * @param <T> Тип елементів, що зберігаються в колекції.
 * @author Onischenko Yevhenii
 */
public interface CollectionInterface<T> extends Iterable<T> {

    /**
     * Додає елемент до колекції.
     *
     * @param element Елемент, який потрібно додати.
     * @return {@code true}, якщо елемент було успішно додано.
     */
    boolean add(T element);

    /**
     * Видаляє вказаний елемент з колекції.
     *
     * @param element Елемент, який потрібно видалити.
     * @return {@code true}, якщо елемент був знайдений та видалений.
     */
    boolean remove(T element);

    /**
     * Повертає кількість елементів у колекції.
     *
     * @return Розмір колекції.
     */
    int size();

    /**
     * Перевіряє, чи порожня колекція.
     *
     * @return {@code true}, якщо колекція не містить елементів.
     */
    boolean isEmpty();

    /**
     * Очищує колекцію, видаляючи всі елементи.
     */
    void clear();

    /**
     * Повертає ітератор для обходу елементів колекції.
     *
     * @return Ітератор.
     */
    @Override
    Iterator<T> iterator();
}