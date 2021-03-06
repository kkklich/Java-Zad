package com.company;

import java.util.RandomAccess;
import java.util.Scanner;
import java.io.*;


//Napisać funkcję public static void sumujIZapisz(String nazwaPliku) , która odczytuje plik o podanej nazwie zawierający liczby całkowite (po jednej w
//wierszu). Funkcja ma za zadanie odczytać i zsumować wszystkie liczby z pliku,
//a następnie dopisać na końcu pliku wyznaczoną sumę powiększoną o 1. Ponowne uruchomienia funkcji będą skutkowały dopisywaniem kolejnych wierszy. Jeżeli
//plik nie istnieje to ma zostać utworzony – suma dla pustego pliku wyniesie 0, a
//więc należy dopisać wiersz zawierający 1.

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
