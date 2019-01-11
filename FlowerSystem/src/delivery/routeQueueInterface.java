/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery;

/**
 *
 * @author Chin You
 */
public interface routeQueueInterface <T>{
    public T dequeue();
    public void enqueue(T data);
    public boolean isEmpty();
    public int size();
    public void clear();
}
