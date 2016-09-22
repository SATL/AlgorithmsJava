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
public class WQuickUnionPathCompressionUF {

    private int[] ids;
    private int[] sizes;

    public WQuickUnionPathCompressionUF(int N) {
        ids = new int[N];
        sizes = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
            sizes[i] = 1;
        }
    }

    private int getRoot(int i) {
        while (i != ids[i]) {
            ids[i] = ids[ids[i]];
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
