package models;

import models.interfaces.IMyStack;
import models.interfaces.MyList;

public class MyStack<T> implements IMyStack<T> {
    private MyList<T> list;

    public MyStack(MyList<T> list) {
        this.list = list;
    }

    /**
     * Returns true or false depending if the stack is empty or not through inner method size().
     * @return true or false
     */
    @Override
    public boolean empty() {
        return list.size() == 0;
    }

    /**
     * Returns the size of the stack by calling inner size() method.
     * @return the size of the stack.
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Returns the top most element through getLast().
     * @return the top most element
     */
    @Override
    public T peek() {
        return list.getLast();
    }

    /**
     * Pushes the element to the top and returns that newly added element.
     * @param element the element to add
     * @return the just added element
     */
    @Override
    public T push(T element) {
        list.add(element);
        return element;
    }

    /**
     * Deletes the top most element and returns it.
     * @return the top most element
     */
    @Override
    public T pop() {
        T temp = list.getLast();
        list.removeLast();
        return temp;
    }
}
