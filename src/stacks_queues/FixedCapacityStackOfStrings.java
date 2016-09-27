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
public class FixedCapacityStackOfStrings implements StackOfStrings{
    private String[] s;
    private int n = 0;
    
    public FixedCapacityStackOfStrings(int capacity){
        s = new String[capacity];
    }
    
    public boolean isEmpty(){
        return n==0;
    }
    
    @Override
    public void push(String item){
        s[n++]= item;
    }
    
    @Override
    public String pop(){
        String item = s[--n];
        s[n]=null;
        return item;
    }
}
