/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogueMaintanance;

import custMaintenanceNPayment.mLinkedInterface;

/**
 *
 * @author Kuma
 */
public class LinkedCircular<T> implements circularLinkedInterface<T> {
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
    
    public LinkedCircular()
    {
        lastNode = null;
    }
    
    public void add(T data)
    {
        Node newNode = new Node(data);
        if(lastNode == null)
        {
            lastNode = newNode;
            lastNode.next = newNode;
        }
        else
        {
            if(count==1)
            {
                newNode.next = lastNode.next;
                lastNode.next = newNode;
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
    
    public T getFront()
    {
        T data = null;
        if(lastNode != null)
        {
            data = lastNode.next.data;
        }
        return data;
    }
    
    
    public T get(int index)
    {
        T data = null;
        if(lastNode!=null)
        {
            Node temp = lastNode.next;
            for(int i=0; i<=index; i++)
            {
                if(i == index)
                {
                    data = temp.data;
                }
                temp = temp.next;
            }
        }
        return data;
    }
    
    public void remove(int index)
    {
        if(lastNode!=null)
        {
            Node temp = lastNode.next;
            Node prev = lastNode.next;
            for(int i=0; i<=index; i++)
            {
                if(i == index)
                {
                    prev.next = temp.next;
                }
                prev = temp;
                temp = temp.next;
            }
            count--;
        }
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
    
    public boolean exist(T data)
    {
        int i=0;
        int c=0;
        for(Node temp=lastNode.next; i<count; temp = temp.next)
        {
            if(temp.data == data)
            {
                c=1;
            }
        }
        if(c==1)
            return true;
        else
            return false;
    }
    
    public int size()
    {
        return count;
    }
}

