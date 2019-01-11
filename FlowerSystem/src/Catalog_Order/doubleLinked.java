/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalog_Order;

import custMaintenanceNPayment.mLinkedInterface;

/**
 *
 * @author Kuma
 */
public class doubleLinked<T> implements doubleLinkedInterface<T> {
    private class Node
    {
        private T data;
        private Node next;
        private Node previous;
        
        private Node()
        {
            this.data = null;
            this.next = null;
            this.previous = null;
        }
        
        private Node(T data)
        {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
        
        private Node(T data, Node next)
        {
            this.data = data;
            this.next = next;
        }
        
        private Node(T data, Node next, Node previous)
        {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }
    
    private Node topNode;
    private Node lastNode;
    private int count=0;
    
    public doubleLinked()
    {
        topNode = null;
    }
    
    public void add(T data)
    {
        Node newNode = new Node(data);
        if(topNode == null)
        {
            topNode = newNode;
            topNode.next = newNode;
            lastNode = newNode;
        }
        else
        {
            if(count==1)
            {
                topNode.next = newNode;
                lastNode = newNode;
                lastNode.previous = topNode;
            }
            else
            {
                lastNode.next = newNode;
                newNode.previous = lastNode;
                lastNode = newNode;
            }
        }
        count++;
    }
    
    public T getFront()
    {
        T data = null;
        if(topNode != null)
        {
            data = topNode.data;
        }
        return data;
    }
    
    
    public T get(int index)
    {
        T data = null;
        if(topNode!=null)
        {
            Node temp = topNode;
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
        if(topNode!=null)
        {
            Node temp = topNode;
            Node prev = topNode;
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
        return topNode==null;
    }
    
    public void clear()
    {
        topNode = null;
        count=0;
    }
    
    public boolean exist(T data)
    {
        int i=0;
        int c=0;
        for(Node temp=topNode; i<count; temp = temp.next)
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
    
    public void addByPosition(int position, T data)
    {
        Node newNode = new Node(data);
        
        int j=0;
        if(position==0 && count==0)
        {
            add(data);
        }            
        else
        {
            if(position == 0 && count !=0)
            {
                topNode.previous = newNode;
                newNode.next = topNode;
                topNode = newNode;
            }
            else
            {
                for(Node temp = topNode; j<count;temp = temp.next)
                {
                    if(j==position)
                    {
                        temp.previous.next = newNode;
                        newNode.previous = temp.previous;
                        temp.previous = newNode;
                        newNode.next = temp;
                    }
                    j++;
                }
            }
            count++;
        }
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
                if(temp.data!=null)
                {
                    s += temp.data;
                    i++;
                }
            }
        }
        
        return s;
    }
    
}