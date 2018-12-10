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
public class mLinked<T> implements mLinkedInterface<T> {
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
    
    private Node topNode;
    private Node lastNode;
    private int count=0;
    
    public mLinked()
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
            if(topNode.next == topNode)
            {
                topNode.next = newNode;
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
    
    public T getFront()
    {
        T data = null;
        if(topNode != null)
        {
            data = topNode.data;
        }
        return data;
    }
    
    public boolean isEmpty()
    {
        return topNode==null;
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
    
}
