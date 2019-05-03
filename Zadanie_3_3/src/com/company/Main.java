package com.company;

import java.util.RandomAccess;
import java.util.Scanner;
import java.io.*;


public class Main {


    public static void sumuj()throws IOException {

        String nazwa = "liczby.txt";
        Scanner in = null;

        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        int suma = 0;

        try {

            in = new Scanner(new BufferedReader(new FileReader(nazwa)));

            int i = 0;
            int[] liczba = new int[20];

            while (in.hasNextInt()) {
                liczba[i] = in.nextInt();
                System.out.println(liczba[i]);
                suma += liczba[i];
                i++;
            }

            System.out.println("suma: " + suma);
            pw = new PrintWriter(new BufferedWriter(new FileWriter(nazwa, true)));
            pw.println(suma);
            pw.close();

        } catch (FileNotFoundException f) {

            System.out.println(f.getMessage());
        } finally {
            if (in != null)
                in.close();
        }

    }


    public static void main(String[] args) throws IOException {

        sumuj();

    }
}
