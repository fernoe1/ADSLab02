package models.interfaces;

/**
 * Interface for the Stack logical data structure.
 */
public interface IMyStack<T> {
    /**
     * Returns true or false depending on if the stack is empty.
     * @return true or false
     */
    boolean empty();

    /**
     * Returns the size of the stack.
     * @return the size of the stack
     */
    int size();

    /**
     * Returns reference to the top most element in the stack.
     * @return the reference to the top most element
     */
    T peek();

    /**
     * Adds an element to the stack and returns that just newly added element.
     * @param element the element to add
     * @return the just newly added element
     */
    T push(T element);

    /**
     * Retrieves and deletes the top most element in the stack.
     * @return the top most element
     */
    T pop();
}
