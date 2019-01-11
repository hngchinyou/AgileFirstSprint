/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalog_Order;

/**
 *
 * @author Kuma
 */
public interface doubleLinkedInterface<T> {
    public T getFront();
    public void add(T data);
    public boolean isEmpty();
    public boolean exist(T data);
    public T get(int index);
    public void clear();
    public void remove(int index);
    public int size();
    public void addByPosition(int position, T data);
}
