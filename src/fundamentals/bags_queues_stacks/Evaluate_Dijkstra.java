/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundamentals.bags_queues_stacks;

import fundamentals.programming_model.StdIn;
import fundamentals.programming_model.StdOut;
import java.util.Stack;

/**
 *
 * @author eslem
 */
public class Evaluate_Dijkstra {
    
    
    private static boolean isOperation(String chr){
        return chr.equals("+") || chr.equals("-") || chr.equals("/") || chr.equals("*");
        
    }
    public static void main(String[] args){
        Stack<String> operations = new Stack<String>();
        Stack<Double> values = new Stack<Double>();
        
        //( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) 
        
        while(!StdIn.isEmpty()){
            String chr = StdIn.readString();
            if(isOperation(chr))
                operations.push(chr);
            else if(chr.equals(")")){
                String op = operations.pop();
                double val = values.pop();
                if(op.equals("+"))
                    val = values.pop() + val;
                if(op.equals("-"))
                    val = values.pop() - val;
                if(op.equals("/"))
                    val = values.pop() / val;
                if(op.equals("*"))
                    val = values.pop() * val;
                
                values.push(val);
            }
            else if(chr.equals("q")){
                break;
            }
            else if(!chr.equals("(")){
                values.push(Double.parseDouble(chr));
            }
                
        }
        StdOut.println(values.pop());
    }
}
