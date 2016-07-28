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
public class BouncingBall {

    static public void animateBall(double x, double y, double vx, double vy, double radius) {

        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();

        while (true) {
            System.out.println("vx: " + vx + " vy:" + vy);
            if (Math.abs(x + vx) > 1) {
                vx = -vx;
            }

            if (Math.abs(y + vy) > 1) {
                vy = -vy;
            }

            x += vx;
            y += vy;

            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.filledSquare(0, 0, 1.0);

            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(x, y, radius);

            StdDraw.show();
            StdDraw.pause(20);
        }
    }

    public static void main(String[] args) {

        double x = 0.480, y = 0.860;
        double vx = 0.01, vy = 0.02;
        double radius = 0.05;

        animateBall(x, y, vx, vy, radius);
        
    }
}
