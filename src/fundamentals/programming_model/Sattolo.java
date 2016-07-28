/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundamentals.programming_model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author eslem
 */
public class Sattolo {

    // this class should not be instantiated
    private Sattolo() {
    }

    /**
     * Rearranges an array of objects to be a uniformly random cycle (under the
     * assumption that <tt>Math.random()</tt> generates independent and
     * uniformly distributed numbers between 0 and 1).
     *
     * @param a the array to be rearranged
     * @see StdRandom
     */
    public static void cycle(Object[] a) {
        int N = a.length;
        for (int i = N; i > 1; i--) {
            // choose index uniformly in [0, i-1)
            int r = (int) (Math.random() * (i - 1));
            Object swap = a[r];
            a[r] = a[i - 1];
            a[i - 1] = swap;
        }
    }

    static class StdIn {

        static String[] readAllStrings() {
            Scanner input = new Scanner(System.in);
            ArrayList<String> list = new ArrayList<>();
            int count = 0;
            String readString = input.nextLine();
            while (readString != null) {
                if (readString.equals("")) {
                    readString = null;
                } else {
                    list.add(readString);
                    readString = input.nextLine();
                }
            }
            String[] arr = new String[list.size()];
            arr = list.toArray(arr);
            return arr;
        }
    }

    static class StdOut {

        static void println(String data) {
            System.out.println(data);
        }
    }

    public static void main(String[] args) {

        // read in the data
        String[] a = StdIn.readAllStrings();

        // shuffle the array
        Sattolo.cycle(a);

        // print results.
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
}
