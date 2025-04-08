package models.interfaces;

/**
 * Interface for heap logical data structure
 */
public interface IMyHeap<T> {
    /**
     * Returns whether the heap is empty.
     * @return true or false
     */
    boolean empty();

    /**
     * Returns the size of the heap.
     * @return the size
     */
    int size();

    /**
     * Returns a reference to root element in the heap.
     * @return the root element
     */
    T getExtremum();

    /**
     * Returns a reference to the root element in the heap and deletes it.
     * @return the root element
     */
    T extractExtremum();

    /**
     * Adds the element to the heap.
     * @param element the element
     */
    void insert(T element);
}
