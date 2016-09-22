/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package union_find;

/**
 *
 * @author eslem
 */
public class QuickFindUF {

    private int[] ids;

    public QuickFindUF(int N) {
        ids = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
        }
    }

    public boolean isConnected(int p, int q) {
        return ids[p] == ids[q];
    }
    
    public void union(int p,  int q){
        if(p>ids.length-1 || q>ids.length-1)
            throw new ArrayIndexOutOfBoundsException();
        
        int idp=ids[p];
        int idq = ids[q];
        
        for(int i=0; i<ids.length; i++)
            if(ids[i]==idp) ids[i]=idq;
            
    }
}
