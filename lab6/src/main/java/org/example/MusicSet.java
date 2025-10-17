package org.example;

import java.util.*;

/**
 * Типізована колекція, що реалізує інтерфейс {@link java.util.Set} для зберігання унікальних
 * музичних композицій. Внутрішня структура даних реалізована за допомогою власного
 * двозв'язного списку, щоб забезпечити ефективне додавання та видалення елементів.
 *
 * @param <T> Тип музичних композицій, що зберігаються в колекції. Повинен бути спадкоємцем {@link MusicalComposition}.
 * @author Onischenko Yevhenii
 */
public class MusicSet<T extends MusicalComposition> implements Set<T> {

    /**
     * Внутрішній статичний клас, що представляє вузол двозв'язного списку.
     * @param <E> Тип даних, що зберігаються у вузлі.
     */
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    /** Вказівник на перший елемент списку (голова). */
    private transient Node<T> head;

    /** Вказівник на останній елемент списку (хвіст). */
    private transient Node<T> tail;

    /** Кількість елементів у колекції. */
    private int size = 0;

    /**
     * Конструктор за замовчуванням. Створює порожню колекцію.
     */
    public MusicSet() {
    }

    /**
     * Конструктор, що створює колекцію з одного початкового елемента.
     *
     * @param composition Єдиний елемент для додавання до нової колекції.
     */
    public MusicSet(T composition) {
        add(composition);
    }

    /**
     * Конструктор, що створює колекцію та ініціалізує її елементами
     * з іншої стандартної колекції. Дублікати ігноруються.
     *
     * @param initialCompositions Колекція, елементи якої будуть додані до цього сету.
     */
    public MusicSet(Collection<? extends T> initialCompositions) {
        addAll(initialCompositions);
    }

    // --- Основні методи інтерфейсу Set ---

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(Object o) {
        // Перевіряємо, чи існує такий елемент
        return findNode(o) != null;
    }

    /**
     * {@inheritDoc}
     * <p>Додає елемент в кінець списку, якщо його ще немає в колекції.
     * Часова складність: O(n) через необхідність перевірки на унікальність.
     */
    @Override
    public boolean add(T t) {
        if (contains(t)) {
            return false; // Елемент вже існує, нічого не робимо
        }

        final Node<T> l = tail;
        final Node<T> newNode = new Node<>(l, t, null);
        tail = newNode;
        if (l == null) {
            head = newNode; // Список був порожнім
        } else {
            l.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * {@inheritDoc}
     * <p>Видаляє вказаний елемент з колекції.
     * Часова складність: O(n) для пошуку елемента.
     */
    @Override
    public boolean remove(Object o) {
        Node<T> nodeToRemove = findNode(o);
        if (nodeToRemove == null) {
            return false; // Елемента немає в списку
        }

        unlinkNode(nodeToRemove);
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        // Допомагаємо збирачу сміття, занулюючи всі посилання
        for (Node<T> x = head; x != null; ) {
            Node<T> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        head = tail = null;
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> lastReturned;
            private Node<T> next = head;

            @Override
            public boolean hasNext() {
                return next != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                lastReturned = next;
                next = next.next;
                return lastReturned.item;
            }

            @Override
            public void remove() {
                if (lastReturned == null) throw new IllegalStateException();
                MusicSet.this.unlinkNode(lastReturned);
                lastReturned = null;
            }
        };
    }

    // --- Допоміжні приватні методи ---

    /**
     * Внутрішній метод для пошуку вузла за об'єктом.
     * @param o Об'єкт для пошуку.
     * @return Вузол, що містить об'єкт, або {@code null}, якщо не знайдено.
     */
    private Node<T> findNode(Object o) {
        if (o == null) return null;
        for (Node<T> x = head; x != null; x = x.next) {
            if (o.equals(x.item)) {
                return x;
            }
        }
        return null;
    }

    /**
     * Внутрішній метод для "вирізання" вузла зі списку.
     * @param x Вузол, який потрібно видалити.
     */
    private void unlinkNode(Node<T> x) {
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;

        if (prev == null) {
            head = next; // Видаляємо голову
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            tail = prev; // Видаляємо хвіст
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
    }

    // --- Методи, що реалізуються через базові операції ---

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T e : c) {
            if (add(e)) modified = true;
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object e : c) {
            if (remove(e)) modified = true;
        }
        return modified;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<T> x = head; x != null; x = x.next) {
            result[i++] = x.item;
        }
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size)
            a = (T1[]) java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        int i = 0;
        Object[] result = a;
        for (Node<T> x = head; x != null; x = x.next)
            result[i++] = x.item;

        if (a.length > size)
            a[size] = null;

        return a;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "MusicSet is empty.";
        }
        Iterator<T> it = iterator();
        StringBuilder sb = new StringBuilder("MusicSet:\n");
        while (it.hasNext()) {
            sb.append("- ").append(it.next()).append("\n");
        }
        return sb.toString();
    }
}