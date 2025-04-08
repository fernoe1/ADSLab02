package models;

import models.interfaces.IMyQueue;

public class MyQueue<T> implements IMyQueue<T> {
    private MyLinkedList<T> myLinkedList;

    public MyQueue() {
        myLinkedList = new MyLinkedList<>();
    }

    /**
     * Returns true or false depending whether the queue is empty through size() method.
     * @return true or false
     */
    @Override
    public boolean empty() {
        return myLinkedList.size() == 0;
    }

    /**
     * Returns the size of the queue through size() method.
     * @return the size of the queue
     */
    @Override
    public int size() {
        return myLinkedList.size();
    }

    /**
     * Returns the element at the front.
     * @return the element at the front
     */
    @Override
    public T peek() {
        return myLinkedList.getFirst();
    }

    /**
     * Adds element to the end.
     * @param element the element to add
     * @return the newly added element
     */
    @Override
    public T enqueue(T element) {
        myLinkedList.addLast(element);
        return element;
    }

    /**
     * Returns the element at the front and deletes it.
     * @return the element at the front
     */
    @Override
    public T dequeue() {
        T temp = myLinkedList.getFirst();
        myLinkedList.removeFirst();
        return temp;
    }
}
