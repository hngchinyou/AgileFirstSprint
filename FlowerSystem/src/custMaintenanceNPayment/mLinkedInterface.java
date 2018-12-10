/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custMaintenanceNPayment;

/**
 *
 * @author Kuma
 */
public interface mLinkedInterface<T> {
    public T getFront();
    public void add(T data);
    public boolean isEmpty();
    public boolean exist(T data);
}
