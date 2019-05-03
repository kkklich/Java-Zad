package com.company;

import  java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code

        /*
        * 4. Napisać program, który wczytuje dwie liczby naturalne oznaczające numer roku i wyświetlający łączną
liczbę dni od 1 stycznia pierwszego podanego roku do 31 grudnia drugiego podanego roku. Należy
uwzględnić lata przestępne. Rok jest przestępny jeżeli jest podzielny przez 4, ale nie jest podzielny przez
100, lub jest podzielny przez 400. Lata przestępne mają 366 dni, natomiast pozostałe 365.
Przykładowo jeżeli użytkownik poda 2000 i 2007, wynikiem powinno być 2922
(bo 366 + 3 * 365 + 366 + 3 * 365).
Inny przykład, jeżeli użytkownik poda 1945 i 1945, to wynikiem powinno być 365.
        * */


        System.out.println("Zad 3 Zetstaw 1 ");
        System.out.println("Obliczanie ilosci dni pomiędzy rokami");

        Scanner scan=new Scanner((System.in));

        System.out.print("Podaj pierwszy rok: ");
        int pierwszyrok=scan.nextInt();
        int drugirok=0;


        do {
            System.out.print("Podaj drugi rok: ");
            drugirok=scan.nextInt();
        }while (drugirok<pierwszyrok);


        int suma=0;


        for (int i=pierwszyrok;i<=drugirok;i++)
        {

                if (i % 4 == 0)
                {

                    if(i%100==0)
                    {

                        if(i%400==0)
                        {
                            suma = suma + 366;
                        }
                        else {
                            suma = suma + 365;
                        }
                    }
                    else
                    {
                        suma = suma + 366;
                    }

                }
                else
                    {
                    suma = suma + 365;
                }

        }

        System.out.println("Ilosc dni: "+suma);

    }
}
