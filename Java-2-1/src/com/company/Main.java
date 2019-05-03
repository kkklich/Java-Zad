package com.company;

import java.util.Scanner;
import  java.util.Random;

public class Main {

    public static void main(String[] args) {
        // write your code here



        /* 1. Napisać program, który tworzy dwuwymiarową tablicę liczb całkowitych o losowej wielkości wymiaru (wylosowanej
z zakresu [50, 100] i podzielnej przez 4), gdzie liczba wierszy jest równa liczbie kolumn. Następnie tablica zostaje
wypełniona liczbami losowymi, z wyjątkiem elementów znajdujących się na przekątnych. Liczby mają być losowane z
zakresu [a, b), gdzie liczby a i b podawane są przez użytkownika. Wartości na przekątnych mają być wypełnione w
losowym układzie w 75% przypadków cyfrą 1, a w pozostałych 25% przypadków wartością -1.
Program powinien wyświetlić na ekran liczbę komórek, których wartość jest mniejsza od iloczynu indeksu wiesza i
kolumny tej komórki.*/

        Random r=new Random();
        int rand;
        do{
            rand= r.nextInt(50) + 50;

        }while (rand%4!=0);

        System.out.println(rand);

        int [][] tablica=new int[rand][rand];

        Scanner in=new Scanner((System.in));
        int a,b,c;

        System.out.print("Podaj początek przedzialu: ");
        a=in.nextInt();
        System.out.print("Podaj koniec przedziału: ");
        b=in.nextInt();
        if(b<=a)
        {
            System.out.print("Druga liczba musi byc wieksza od pierwszej, podaj jeszcze raz");
            b=in.nextInt();
        }

        c=b-a;
       // rand=4;

        int liczba;




        int nrprzekatnej=0;
        int iloczyn,ilosc=0;

        for (int i=0;i<rand;i++)
        {
            for (int j=0;j<rand;j++)
            {
                if(i==j || i+j==rand-1) {


                    liczba=r.nextInt(100);
                    if(liczba<25)
                    {
                        tablica[i][j]=-1;
                    }
                    else
                    {
                        tablica[i][j]=1;
                    }

                }
                else {
                    tablica[i][j] = r.nextInt(c) + a;
                }

                iloczyn=i*j;
                if(tablica[i][j]<iloczyn) {
                    ilosc++;
                }
                System.out.print(tablica[i][j]+" ");
            }
            System.out.println("");
        }

        System.out.print("Ilosc liczb mniejszych od iloczyny"+ilosc);
    }
}
