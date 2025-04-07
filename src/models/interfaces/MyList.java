package models.interfaces;

import java.util.Comparator;

/**
 * A list interface for sequenced storage of elements.
 * @param <T> the element's type that is being stored
 */
public interface MyList<T> extends Iterable<T> {
    /**
     * Adds an element to a list.
     * @param element element to be added
     */
    void add(T element);

    /**
     * Sets the element at the given index to a new element.
     * @param index index of the element to replace
     * @param element element to be set at the specified position
     */
    void set(int index, T element);

    /**
     * Inserts the given element at the specified index.
     * @param index the position to insert the element at
     * @param element the element to be inserted at the specified position
     */
    void add(int index, T element);

    /**
     * Inserts the given element to the first position.
     * @param element the element to be inserted
     */
    void addFirst(T element);

    /**
     * Inserts the given element to the last position.
     * @param element the element to be inserted
     */
    void addLast(T element);

    /**
     * Gets the element at the specified index.
     * @param index index of the position you want to get the element from
     * @return the element at that position
     */
    T get(int index);

    /**
     * Gets the first element in the sequence.
     * @return the first element in the sequence
     */
    T getFirst();

    /**
     * Gets the last element in the sequence.
     * @return the last element in the sequence
     */
    T getLast();

    /**
     * Removes the element at the specified position.
     * @param index the index to remove the element at
     */
    void remove(int index);

    /**
     * Removes the first element.
     */
    void removeFirst();

    /**
     * Removes the last element.
     */
    void removeLast();

    /**
     * Sorts the sequence.
     */
    void sort(Comparator<T> cmp);

    /**
     * Returns the index of the specified object.
     * @param object the object you want to find the index of in the sequence
     * @return index of the object
     */
    int indexOf(Object object);

    /**
     * Returns the last occurrence of the specified object.
     * @param object the object you want to find the last occurrence of
     * @return the last occurrence index of the specified object
     */
    int lastIndexOf(Object object);

    /**
     * Returns true or false depending on if the object exists in the sequence or not.
     * @param object the object to determine if it exists or not
     * @return true or false
     */
    boolean exists(Object object);

    /**
     * Turns the sequence into a primitive array.
     * @return primitive array of the sequence
     */
    public Object[] toArray();

    /**
     * Clears the sequence.
     */
    void clear();

    /**
     * Returns the amount of elements in the sequence.
     * @return amount of elements in the sequence.
     */
    int size();
}
