package models;

import models.interfaces.IMyQueue;
import models.interfaces.MyList;

public class MyQueue<T> implements IMyQueue<T> {
    private MyList<T> list;

    public MyQueue(MyList<T> list) {
        this.list = list;
    }

    /**
     * Returns true or false depending whether the queue is empty through size() method.
     * @return true or false
     */
    @Override
    public boolean empty() {
        return list.size() == 0;
    }

    /**
     * Returns the size of the queue through size() method.
     * @return the size of the queue
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Returns the element at the front.
     * @return the element at the front
     */
    @Override
    public T peek() {
        return list.getFirst();
    }

    /**
     * Adds element to the end.
     * @param element the element to add
     * @return the newly added element
     */
    @Override
    public T enqueue(T element) {
        list.addLast(element);
        return element;
    }

    /**
     * Returns the element at the front and deletes it.
     * @return the element at the front
     */
    @Override
    public T dequeue() {
        T temp = list.getFirst();
        list.removeFirst();
        return temp;
    }
}
