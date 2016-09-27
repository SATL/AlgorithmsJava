/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacks_queues;

/**
 *
 * @author eslem
 */
public class LinkedQueueOfStrings {
    private NodeString first, last;
    
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public void enqueue(String item){
        NodeString oldLast = last;
        
        last = new NodeString();
        last.item = item;
        last.next = null;
        
        if(isEmpty()) first =last;
        else    oldLast.next = last;
    }
    
    public String dequeue(){
        String item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        
        return item;
    }
}
