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
	public void add(int pos,T newData) {
		Node newNode = new Node(newData);
		
//		if(this.topNode == null && count != 0) { //if head is null and position is zero skip it.
//			return;
//		} else if(this.topNode == null && count == 0) { // if head null and position is zero set at the head.
//			this.topNode = newNode;
//		}
 
		if(count == 0) {
			newNode.next = topNode;
			topNode = newNode;
			lastNode= newNode;
		}
 
		Node current = topNode;
		Node previous = topNode;
		int i = 0;
 
		while(i < pos) {
			previous = current;
			current = current.next;
			if(current == null)
				break;
			i++;
		}
 
		newNode.next = current;
		previous.next = newNode;
		count++;
	}
	
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
            if(count==1)
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
    
    public int size()
    {
        return count;
    }
}
