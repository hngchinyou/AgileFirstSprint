/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import custMaintenanceNPayment.mLinked;

/**
 *
 * @author Tarc
 */
public class LinkQueue<T> implements routeQueueInterface<T> {
private class Node
    {
        private T data;
        private Node next;
        
        private Node(T data)
        {
            this.data = data;
            this.next = null;
        }
        
        private Node(T data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }
    
    private Node lastNode;
    private int count=0;

    public LinkQueue() 
    {
        lastNode = null;
    }
    
    public void enqueue(T data)
    {
        Node newNode = new Node(data);
        if(count==0)
        {
            lastNode = newNode;
        }
        else
        {
            if(count==1)
            {
                lastNode.next = newNode;
                newNode.next = lastNode;
                lastNode = newNode;
            }
            else
            {
                newNode.next = lastNode.next;
                lastNode.next = newNode;
                lastNode = newNode;
            }
        }
        count++;
    }
    
    public T dequeue()
    {
        T data=null;
        if(count==0)
        {
            data = (T)"";
            count=0;
        }
        else
        {
            if(count == 1)
            {
                data = lastNode.data;
                lastNode = null;
                count=0;
            }
            else
            {
                data = lastNode.next.data;
                lastNode.next = lastNode.next.next;
                count--;
            }
        }
           
        return data;
    }
    
    public boolean isEmpty()
    {
        return lastNode==null;
    }
    
    public void clear()
    {
        lastNode = null;
        count=0;
    }
    
    public int size()
    {
        return count;
    }
    
    @Override
    public String toString()
    {
        String s = "";
        int i=0;
        
        if(!isEmpty())
        {
            for(Node temp = lastNode.next; i<count; temp = temp.next)
            {
                s += temp.data;
                i++;
            }
        }
        
        return s;
    }
}
