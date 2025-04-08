package models;

import models.interfaces.IMyStack;

public class MyStack<T> implements IMyStack<T> {
    private MyArrayList<T> myArrayList;

    public MyStack() {
        myArrayList = new MyArrayList<>();
    }

    /**
     * Returns true or false depending if the stack is empty or not through inner method size().
     * @return true or false
     */
    @Override
    public boolean empty() {
        return myArrayList.size() == 0;
    }

    /**
     * Returns the size of the stack by calling inner size() method.
     * @return the size of the stack.
     */
    @Override
    public int size() {
        return myArrayList.size();
    }

    /**
     * Returns the top most element through getLast().
     * @return the top most element
     */
    @Override
    public T peek() {
        return myArrayList.getLast();
    }

    /**
     * Pushes the element to the top and returns that newly added element.
     * @param element the element to add
     * @return the just added element
     */
    @Override
    public T push(T element) {
        myArrayList.add(element);
        return element;
    }

    /**
     * Deletes the top most element and returns it.
     * @return the top most element
     */
    @Override
    public T pop() {
        T temp = myArrayList.getLast();
        myArrayList.removeLast();
        return temp;
    }
}
