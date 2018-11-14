/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obrot_kostki;

import java.util.Scanner;
import Jama.Matrix; //importuje class Matrix
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Math; //sinus i cosinus oraz potega

/**
 *
 * @author AGA
 */
public class Obrot_kostki {

    /**
     * @param args the command line arguments
     */
    static Scanner scan = new Scanner(System.in);

    public static void wczytaj_dane() throws FileNotFoundException {

        double[][] wierzcholek_1 = {{1.0}, {1.0}, {1.0}, {1.0}};
        Matrix wierz_1 = new Matrix(wierzcholek_1, 4, 1); //macierz pionowa wierzchołek nr 1 wartosc poczatkowa

        double[][] wierzcholek_2 = {{1.0}, {1.0}, {-1.0}, {1.0}};
        Matrix wierz_2 = new Matrix(wierzcholek_2, 4, 1); //macierz pionowa wierzchołek nr 2 wartosc poczatkowa

        double[][] wierzcholek_3 = {{1.0}, {-1.0}, {-1.0}, {1.0}};
        Matrix wierz_3 = new Matrix(wierzcholek_3, 4, 1); //macierz pionowa wierzchołek nr 3 wartosc poczatkowa

        double[][] wierzcholek_4 = {{-1.0}, {-1.0}, {-1.0}, {1.0}};
        Matrix wierz_4 = new Matrix(wierzcholek_4, 4, 1); //macierz pionowa wierzchołek nr 4 wartosc poczatkowa

        double[][] wierzcholek_5 = {{-1.0}, {-1.0}, {1.0}, {1.0}};
        Matrix wierz_5 = new Matrix(wierzcholek_5, 4, 1); //macierz pionowa wierzchołek nr 5 wartosc poczatkowa

        double[][] wierzcholek_6 = {{-1.0}, {1.0}, {1.0}, {1.0}};
        Matrix wierz_6 = new Matrix(wierzcholek_6, 4, 1); //macierz pionowa wierzchołek nr 6 wartosc poczatkowa

        double[][] wierzcholek_7 = {{-1.0}, {1.0}, {-1.0}, {1.0}};
        Matrix wierz_7 = new Matrix(wierzcholek_7, 4, 1); //macierz pionowa wierzchołek nr 7 wartosc poczatkowa

        double[][] wierzcholek_8 = {{1.0}, {-1.0}, {1.0}, {1.0}};
        Matrix wierz_8 = new Matrix(wierzcholek_8, 4, 1); //macierz pionowa wierzchołek nr 8 wartosc poczatkowa

        System.out.println("Podaj kolejno współrzędne x0, y0 i z0: ");
        double x0;
        x0 = scan.nextDouble();

        double y0;
        y0 = scan.nextDouble();

        double z0;
        z0 = scan.nextDouble();

        //macierz 1. translacji 4x4
        double[][] translacja_1 = {{1.0, 0.0, 0.0, -x0}, {0.0, 1.0, 0.0, -y0}, {0.0, 0.0, 1.0, -z0}, {0.0, 0.0, 0.0, 1.0}};
        Matrix transl_1 = new Matrix(translacja_1, 4, 4);

        //macierz 2. translacji 4x4
        double[][] translacja_2 = {{1.0, 0.0, 0.0, x0}, {0.0, 1.0, 0.0, y0}, {0.0, 0.0, 1.0, z0}, {0.0, 0.0, 0.0, 1.0}};
        Matrix transl_2 = new Matrix(translacja_2, 4, 4);

        double t = 0.0; // t = 0..1, przy kazdym kroku dodać 1/100!
        
        System.out.println("Podaj kolejno kąt: alfa, beta, gamma (w stopniach): ");
        double alfa;
        alfa = scan.nextDouble();

        double beta;
        beta = scan.nextDouble();

        double gamma;
        gamma = scan.nextDouble();

        System.out.println("Podaj ile razy chcesz przeskalować (przy założeniu, że k > 0): ");
        double k;
        k = scan.nextDouble();


        //obliczenia: ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
        //macierz wierzcholek 1 - wynik
        double[][] wierzcholek_1_wynik = {{0.0}, {0.0}, {0.0}, {0.0}};
        Matrix wierz_1_wynik = new Matrix(wierzcholek_1_wynik, 4, 1);

        //macierz wierzcholek 2 - wynik
        double[][] wierzcholek_2_wynik = {{0.0}, {0.0}, {0.0}, {0.0}};
        Matrix wierz_2_wynik = new Matrix(wierzcholek_2_wynik, 4, 1);

        //macierz wierzcholek 3 - wynik
        double[][] wierzcholek_3_wynik = {{0.0}, {0.0}, {0.0}, {0.0}};
        Matrix wierz_3_wynik = new Matrix(wierzcholek_3_wynik, 4, 1);

        //macierz wierzcholek 4 - wynik
        double[][] wierzcholek_4_wynik = {{0.0}, {0.0}, {0.0}, {0.0}};
        Matrix wierz_4_wynik = new Matrix(wierzcholek_4_wynik, 4, 1);

        //macierz wierzcholek 5 - wynik
        double[][] wierzcholek_5_wynik = {{0.0}, {0.0}, {0.0}, {0.0}};
        Matrix wierz_5_wynik = new Matrix(wierzcholek_5_wynik, 4, 1);

        //macierz wierzcholek 6 - wynik
        double[][] wierzcholek_6_wynik = {{0.0}, {0.0}, {0.0}, {0.0}};
        Matrix wierz_6_wynik = new Matrix(wierzcholek_6_wynik, 4, 1);

        //macierz wierzcholek 7 - wynik
        double[][] wierzcholek_7_wynik = {{0.0}, {0.0}, {0.0}, {0.0}};
        Matrix wierz_7_wynik = new Matrix(wierzcholek_7_wynik, 4, 1);

        //macierz wierzcholek 8 - wynik
        double[][] wierzcholek_8_wynik = {{0.0}, {0.0}, {0.0}, {0.0}};
        Matrix wierz_8_wynik = new Matrix(wierzcholek_8_wynik, 4, 1);

        //Macierz transformacji M, 100 kroków pośrednich
        double[][] transformacja = {{0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0}};
        Matrix transform = new Matrix(transformacja, 4, 4);

        PrintWriter wierz1 = new PrintWriter("wierz3.txt");

        wierz1.println("# x y z");

        
        for (int i = 0; i <= 100; i++) {

            //macierz obrotu o kat alfa w zaleznosci od czasu t wzdluz osi z
            double[][] obrot_alfa = {{Math.cos(t * Math.toRadians(alfa)), -Math.sin(t * Math.toRadians(alfa)), 0.0, 0.0},
            {Math.sin(t * Math.toRadians(alfa)), Math.cos(t * Math.toRadians(alfa)), 0.0, 0.0},
            {0.0, 0.0, 1.0, 0.0},
            {0.0, 0.0, 0.0, 1.0}};
            Matrix obr_alfa = new Matrix(obrot_alfa, 4, 4);

            //macierz obrotu o kat beta w zaleznosci od czasu t wzdluz osi y
            double[][] obrot_beta = {{Math.cos(t * Math.toRadians(beta)), 0.0, Math.sin(t * Math.toRadians(beta)), 0.0},
            {0.0, 1.0, 0.0, 0.0},
            {-Math.sin(t * Math.toRadians(beta)), 0.0, Math.cos(t * Math.toRadians(beta)), 0.0},
            {0.0, 0.0, 0.0, 1.0}};
            Matrix obr_beta = new Matrix(obrot_beta, 4, 4);

            //macierz obrotu o kat gamma w zaleznosci od czasu t wzdluz osi x
            double[][] obrot_gamma = {{1.0, 0.0, 0.0, 0.0},
            {0.0, Math.cos(t * Math.toRadians(gamma)), -Math.sin(t * Math.toRadians(gamma)), 0.0},
            {0.0, Math.sin(t * Math.toRadians(gamma)), Math.cos(t * Math.toRadians(gamma)), 0.0},
            {0.0, 0.0, 0.0, 1.0}};
            Matrix obr_gamma = new Matrix(obrot_gamma, 4, 4);

            //macierz skalowania w zaleznosci od t
            double[][] skala = {{Math.pow(k, t), 0.0, 0.0, 0.0},
            {0.0, Math.pow(k, t), 0.0, 0.0},
            {0.0, 0.0, Math.pow(k, t), 0.0},
            {0.0, 0.0, 0.0, 1.0}};
            Matrix skalowanie = new Matrix(skala, 4, 4);

            transform = skalowanie.times(obr_gamma).times(obr_beta).times(obr_alfa); //uniwersalne dla wszystkich wierzcholkow, ale rozne w zaleznosci od t
        
            wierz_1_wynik = transl_2.times(transform).times(transl_1).times(wierz_1);
            wierz_2_wynik = transl_2.times(transform).times(transl_1).times(wierz_2);
            wierz_3_wynik = transl_2.times(transform).times(transl_1).times(wierz_3);
            wierz_4_wynik = transl_2.times(transform).times(transl_1).times(wierz_4);
            wierz_5_wynik = transl_2.times(transform).times(transl_1).times(wierz_5);
            wierz_6_wynik = transl_2.times(transform).times(transl_1).times(wierz_6);
            wierz_7_wynik = transl_2.times(transform).times(transl_1).times(wierz_7);
            wierz_8_wynik = transl_2.times(transform).times(transl_1).times(wierz_8);

            wierz1.println(wierz_7_wynik.get(0, 0) +" "+wierz_7_wynik.get(1, 0) +" "+wierz_7_wynik.get(2, 0));
            wierz1.println(wierz_2_wynik.get(0, 0) +" "+wierz_2_wynik.get(1, 0) +" "+wierz_2_wynik.get(2, 0));
            wierz1.println(wierz_1_wynik.get(0, 0) +" "+wierz_1_wynik.get(1, 0) +" "+wierz_1_wynik.get(2, 0));
            wierz1.println(wierz_6_wynik.get(0, 0) +" "+wierz_6_wynik.get(1, 0) +" "+wierz_6_wynik.get(2, 0));
            wierz1.println(wierz_7_wynik.get(0, 0) +" "+wierz_7_wynik.get(1, 0) +" "+wierz_7_wynik.get(2, 0));
            wierz1.println("");
            wierz1.println(wierz_4_wynik.get(0, 0) +" "+wierz_4_wynik.get(1, 0) +" "+wierz_4_wynik.get(2, 0));
            wierz1.println(wierz_3_wynik.get(0, 0) +" "+wierz_3_wynik.get(1, 0) +" "+wierz_3_wynik.get(2, 0));
            wierz1.println(wierz_8_wynik.get(0, 0) +" "+wierz_8_wynik.get(1, 0) +" "+wierz_8_wynik.get(2, 0));
            wierz1.println(wierz_5_wynik.get(0, 0) +" "+wierz_5_wynik.get(1, 0) +" "+wierz_5_wynik.get(2, 0));
            wierz1.println(wierz_4_wynik.get(0, 0) +" "+wierz_4_wynik.get(1, 0) +" "+wierz_4_wynik.get(2, 0));
            wierz1.println("");
            //wierz1.println("");
           
            //gnuplot wydruk 100 klatek dla kazdego wierzcholka
            t += 1.0 / 100;

        }
        
        wierz1.close();

    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        wczytaj_dane();
        Runtime.getRuntime().exec("cmd /c start cmd.exe /K C:\\gnuplot\\bin\\gnuplot");
        scan.close();
    }

}
