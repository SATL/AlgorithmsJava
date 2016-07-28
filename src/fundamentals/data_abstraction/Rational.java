/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundamentals.data_abstraction;

import fundamentals.programming_model.StdOut;

/**
 *
 * @author eslem
 */
public class Rational {

    private long numerator;
    private long denominator;

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    Rational(long numerator, long denominator) {

        if (denominator == 0) {
            throw new RuntimeException("Denominator can not be 0");
        }

        this.numerator = numerator;
        this.denominator = denominator;

        reduce();
    }

    private void reduce() {
        long gdc = euc_gdc(this.numerator, this.denominator);
        this.numerator /= gdc;
        this.denominator /= gdc;
    }

    private static long euc_gdc(long a, long b) {
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }

        if (b == 0) {
            return a;
        }

        return euc_gdc(b, a % b);
    }

    Rational plus(Rational b) {
        long gcd = this.denominator * b.getDenominator();
        long num1 = (gcd / this.denominator) * this.numerator;
        long num2 = (gcd / b.getDenominator()) * b.getNumerator();

        return new Rational(num1 + num2, gcd);
    }

    Rational minus(Rational b) {
        long gcd = this.denominator * b.getDenominator();
        long num1 = (gcd / this.denominator) * this.numerator;
        long num2 = (gcd / b.getDenominator()) * b.getNumerator();

        return new Rational(num1 - num2, gcd);
    }

    Rational times(Rational b) {
        return new Rational(this.numerator * b.getNumerator(), this.denominator * b.getDenominator());
    }

    Rational divides(Rational b) {
        return new Rational(this.numerator / b.getNumerator(), this.denominator / b.getDenominator());
    }

    public String toString() {
        if(this.numerator == this.denominator)
            return ""+this.numerator;
        return this.numerator + "/" + this.denominator;
    }

    // return gcd(|m|, |n|)
    private static long gcd(long m, long n) {
        if (m < 0) {
            m = -m;
        }
        if (n < 0) {
            n = -n;
        }
        if (0 == n) {
            return m;
        } else {
            return gcd(n, m % n);
        }
    }

    private static long lcm(long m, long n) {
        if (m < 0) {
            m = -m;
        }
        if (n < 0) {
            n = -n;
        }
        return m * (n / gcd(m, n));
    }

    public int compareTo(Rational that) {
        long lhs = this.numerator * that.getDenominator();
        long rhs = this.denominator * that.getNumerator();
        if (lhs < rhs) {
            return -1;
        }
        if (lhs > rhs) {
            return +1;
        }
        return 0;
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        Rational that = (Rational) other;
        return this.compareTo(that) == 0;
    }

    public static void main(String[] args) {
        Rational x, y, z;

        // 1/2 + 1/3 = 5/6
        x = new Rational(1, 2);
        y = new Rational(1, 3);
        z = x.plus(y);
        StdOut.println(z);

        // 8/9 + 1/9 = 1
        x = new Rational(8, 9);
        y = new Rational(1, 9);
        z = x.plus(y);
        StdOut.println(z);

    }

}
