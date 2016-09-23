package percolation;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 *
 * @author eslem
 */
public class Percolation {

    private boolean[][] opened;
    private int top = 0;
    private int bottom;
    private int size;
    private WeightedQuickUnionUF qf;

    /**
     * Creates N-by-N grid, with all sites blocked.
     * 
     * @param n
     */
    public Percolation(int n) {
        size = n;
        bottom = size * size + 1;
        qf = new WeightedQuickUnionUF(size * size + 2);
        opened = new boolean[size][size];
    }

    /**
     * Opens site (row i, column j) if it is not already.
     * 
     * @param i
     * @param j
     */
    public void open(int i, int j) {
        opened[i - 1][j - 1] = true;
        if (i == 1) {
            qf.union(getQFIndex(i, j), top);
        }
        if (i == size) {
            qf.union(getQFIndex(i, j), bottom);
        }

        if (j > 1 && isOpen(i, j - 1)) {
            qf.union(getQFIndex(i, j), getQFIndex(i, j - 1));
        }
        if (j < size && isOpen(i, j + 1)) {
            qf.union(getQFIndex(i, j), getQFIndex(i, j + 1));
        }
        if (i > 1 && isOpen(i - 1, j)) {
            qf.union(getQFIndex(i, j), getQFIndex(i - 1, j));
        }
        if (i < size && isOpen(i + 1, j)) {
            qf.union(getQFIndex(i, j), getQFIndex(i + 1, j));
        }
    }

    /**
     * Is site (row i, column j) open?
     * 
     * @param i
     * @param j
     * @return
     */
    public boolean isOpen(int i, int j) {
        return opened[i - 1][j - 1];
    }

    /**
     * Is site (row i, column j) full?
     * 
     * @param i
     * @param j
     * @return
     */
    public boolean isFull(int i, int j) {
        if (0 < i && i <= size && 0 < j && j <= size) {
            return qf.connected(top, getQFIndex(i, j));
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    

    /**
     * Does the system percolate?
     * 
     * @return
     */
    public boolean percolates() {
        return qf.connected(top, bottom);
    }

    private int getQFIndex(int i, int j) {
        return size * (i - 1) + j;
    }
}
