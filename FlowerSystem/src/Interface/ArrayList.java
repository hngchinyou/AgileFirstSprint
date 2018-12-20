/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 *
 * @author User
 */
public class ArrayList<T> implements ListInterface<T> {

    private static final int INITIAL_CAPACITY = 100;

    private T[] list;

    private int size;

    public ArrayList() {
        this(INITIAL_CAPACITY);
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            list = (T[]) new Object[initialCapacity];
        }

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size < 0;
    }

    public boolean add(T newEntry) {
        if (isFull()) {
            doubleArray();
        }
        list[size] = newEntry;
        size++;
        return true;
    }

    public void doubleArray() {

        T[] oldArray = list;
        int oldSize = oldArray.length;

        list = (T[]) new Object[oldSize * 2];
        list = oldArray.clone();

    }

    public boolean isFull() {
        return size == list.length;
    }

    public T remove(int index) {

        T oldValue = list[index];

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(list, index + 1, list, index,
                    numMoved);
        }
        list[--size] = null; // clear to let GC do its work
        size --;
        return oldValue;

    }

    public T get(int index) {

        if (index > size) {
            System.out.println("Index not found");
        }

        return list[index];

    }

  

    public Iterator<T> getIterator() {
        return new IteratorForArrayList();
    } // end getIterator

    public class IteratorForArrayList implements Iterator<T> {

        
         int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        private int nextIndex;
        private boolean wasNextCalled; // needed by remove

        private IteratorForArrayList() {
            nextIndex = 0;
            wasNextCalled = false;
        } // end default constructor

        //    < Implementations of the methods in the interface Iterator go here;
        //      you can see them in Segments 15.26 through 15.28. >
        //    . . .
        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public T next() {
            if (hasNext()) {
                wasNextCalled = true;
                T nextEntry = list[nextIndex];
                nextIndex++; // advance iterator

                return nextEntry;
            } else {
                throw new NoSuchElementException("Illegal call to next();"
                        + "iterator is after end of list.");
            }
        }

        public void remove() {
            if (wasNextCalled) {
                // nextIndex was incremented by the call to next, so it 
                // is the position number of the entry to be removed
                ArrayList.this.remove(nextIndex);
                nextIndex--;           // index of next entry in iteration
                wasNextCalled = false; // reset flag
            } else {
                throw new IllegalStateException("Illegal call to remove(); "
                        + "next() was not called.");
            }
        }
        
         public void forEachRemaining(Consumer<? super T> consumer) {
          //  Objects.requireNonNull(consumer);
            final int size = ArrayList.this.size;
            int i = cursor;
            if (i >= size) {
                return;
            }
            final Object[] elementData = ArrayList.this.list;
            if (i >= elementData.length) {
                throw new ConcurrentModificationException();
            }
            while (i != size ) {
                consumer.accept((T) elementData[i++]);
            }
            // update once at end of iteration to reduce heap write traffic
            cursor = i;
            lastRet = i - 1;
         //   checkForComodification();
        }
    }
    
    
    

    // end IteratorForArrayList
}
