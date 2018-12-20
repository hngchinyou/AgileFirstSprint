/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.Iterator;

/**
 *
 * @author User
 */
public interface ListInterface<T> {

    int size();

    boolean isEmpty();

    boolean add(T e);

    T remove(int index);


    T get(int index);

    public Iterator<T> getIterator();

}
