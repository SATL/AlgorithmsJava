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
public class ResizingArrayStackOfStrings implements StackOfStrings{
    
   private String[] s;
    private int n = 0;
    
    public ResizingArrayStackOfStrings(){
        s = new String[1];
    }
    
    public boolean isEmpty(){
        return n==0;
    }
    
   @Override
    public void push(String item){
        if(n==s.length) resize(n*2);
        s[n++]= item;
    }
    
   @Override
    public String pop(){
        String item = s[--n];
        s[n]=null;
        
        if(n>0 && n == s.length/4) resize(s.length/2);
        return item;
    }
    
    
    private void resize(int capacity){
        String[] new_s = new String[capacity];
        for(int i=0; i<s.length; i++)
            new_s[i] = s[i];
        
        s = new_s;
    }
    
}
