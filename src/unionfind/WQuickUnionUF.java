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
public class WQuickUnionUF {

    private int[] ids;
    private int[] sizes;

    public WQuickUnionUF(int N) {
        ids = new int[N];
        sizes = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
            sizes[i] = 1;
        }
    }

    private int getRoot(int i) {
        while (i != ids[i]) {
            i = ids[i];
        }
        return i;
    }

    public boolean isConnected(int p, int q) {
        return getRoot(p) == getRoot(q);
    }

    public void union(int p, int q) {
        int i = getRoot(p);
        int j = getRoot(q);
        if (i == j) {
            return;
        }
        if (sizes[i] < sizes[j]) {
            ids[i] = j;
            sizes[j] += sizes[i];
        } else {
            ids[j] = i;
            sizes[i] += sizes[j];
        }
    }
}
