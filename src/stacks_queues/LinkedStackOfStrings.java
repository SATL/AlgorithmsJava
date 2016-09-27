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
public class LinkedStackOfStrings {
    private NodeString first = null;
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public void push(String item){
        NodeString oldFirst = first;
        
        first  = new NodeString();
        first.item = item;
        
        first.next = oldFirst;
    }
    
    
    public String pop(){
        String item = first.item;
        first = first.next;        
        return item;
    }
}
