package models.interfaces;

/**
 * Interface for queue logical data structure.
 */
public interface IMyQueue<T> {
    /**
     * Returns whether the queue is empty.
     * @return true or false
     */
    boolean empty();

    /**
     * Returns the size of the queue.
     * @return the size of the queue
     */
    int size();

    /**
     * Returns the reference to the front element of the queue.
     * @return the element at the front
     */
    T peek();

    /**
     * Adds the element to the end of queue.
     * @param element the element to add
     * @return the newly added element
     */
    T enqueue(T element);

    /**
     * Retrieves and deletes the element at the front.
     * @return the element at the front
     */
    T dequeue();
}
