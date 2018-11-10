/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obrot_kostki;

import java.util.Scanner;

/**
 *
 * @author AGA
 */
public class Obrot_kostki {

    /**
     * @param args the command line arguments
     */
    static Scanner scan = new Scanner(System.in);

    public static void wczytaj() {

        System.out.println("Podaj kolejno współrzędne x0, y0 i z0: ");
        double x;
        x = scan.nextDouble();

        double y;
        y = scan.nextDouble();

        double z;
        z = scan.nextDouble();

        System.out.println("Podaj ile razy chcesz przeskalować (przy założeniu, że k>0): ");
        double k;
        k = scan.nextDouble();

        System.out.print("Podaj kolejno kąt: alfa, beta, gamma (w stopniach): ");
        double alfa;
        alfa = scan.nextDouble();

        double beta;
        beta = scan.nextDouble();

        double gamma;
        gamma = scan.nextDouble();

    }

    public static void main(String[] args) {
        wczytaj();
        scan.close();
    }

}
