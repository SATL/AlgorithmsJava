/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundamentals.programming_model;

/**
 *
 * @author eslem
 */
class _NainRef {

    private int count = 0;
    private String id;

    _NainRef(String id) {
        this.id = id;
    }

    public void increment() {
        this.count++;
    }

    public String toString() {
        return this.id + " " + this.count;
    }

}

public class NainRef {

    public static void increment(_NainRef ref) {
        ref.increment();
    }

    public static void main(String[] args) {
        _NainRef one = new _NainRef("One");
        one.increment();
        System.out.println(one);
        _NainRef two = one;
        two.increment();
        System.out.println(one);
        System.out.println(two);

        _NainRef method = new _NainRef("Method");
        System.out.println(method);
        increment(method);

        System.out.println(method);

        String string1 = "hello";
        String string2 = string1;

        string1 = "world";
        StdOut.println(string1);
        StdOut.println(string2);

    }

}
