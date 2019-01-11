/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customized;

import delivery.routeQueueInterface;

/**
 *
 * @author Kuma
 */
public class LinkedSqueue<T> implements squeueInterface<T> {
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
    private Node topNode;
    private int count=0;

    public LinkedSqueue() 
    {
        lastNode = null;
    }
    
    public void enqueue(T data)
    {
        Node newNode = new Node(data);
        if(count==0)
        {
            lastNode = newNode;
            topNode = newNode;
        }
        else
        {
            if(count==1)
            {
                lastNode.next = newNode;
                lastNode = newNode;
            }
            else
            {
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
                data = topNode.data;
                lastNode = null;
                topNode = null;
                count=0;
            }
            else
            {
                data = topNode.data;
                topNode = topNode.next;
                count--;
            }
        }
        return data;
    }
    
    public boolean isEmpty()
    {
        return topNode==null;
    }
    
    public void clear()
    {
        lastNode = null;
        topNode = null;
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
            for(Node temp = topNode; i<count; temp = temp.next)
            {
                s += temp.data;
                i++;
            }
        }
        
        return s;
    }
}
