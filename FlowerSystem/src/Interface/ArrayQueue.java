/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author taruc
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    private T[] queue;
    private int backIndex;
    private static final int frontIndex = 0;
    private static final int initialCapacity = 50;

    public ArrayQueue() {
        this(initialCapacity);
    }

    public ArrayQueue(int initialCapacity) {
        queue = (T[]) new Object[initialCapacity];
        backIndex = -1;
    }

    public void enqueue(T newEntry) {

        if (isArrayFull()) {
            doubleArray();
        }
        backIndex++;
        queue[backIndex] = newEntry;
    }

    public T getFront() {
        T front = null;
        if (!isEmpty()) {
            front = queue[frontIndex];

        }

        return front;
    }

    public T dequeue() {
        T front = null;
        if (!isEmpty()) {
            front = queue[frontIndex];
            
            for(int i = frontIndex ; i < backIndex ; i++ ){
              queue[i] = queue[i+1] ;
            }
          
        }

        return front;
    }
    public int size(){
        return backIndex;
    }
    
    private boolean isArrayFull() {
        return backIndex == queue.length - 1;
    }

    private void doubleArray() {
        T[] oldQueue = queue;
        int oldSize = oldQueue.length;

        queue = (T[]) new Object[oldSize * 2];
        queue = oldQueue.clone();

    }

    public boolean isEmpty() {
        return backIndex == -1;
    }

    public void clear() {
        backIndex = -1;
    }
}
