/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unionfind;

/**
 *
 * @author eslem
 */
public class QuickUnionUF {
    private int[] ids;
    
    public QuickUnionUF(int n) {
        ids = new int[n];
        for (int i = 0; i < n; i++)
            ids[i] = i;
    }
    
    
    private int getRoot(int i) {
        while (i != ids[i]) i = ids[i];
        return i;
    }
    
    public boolean isConnected(int p, int q) {
        return getRoot(p) == getRoot(q);
    }
    
    public void union(int p, int q) {
        int i = getRoot(p);
        int j = getRoot(q);
        ids[i] = j;
    }
}
