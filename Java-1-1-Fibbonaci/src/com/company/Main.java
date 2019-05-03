package com.company;

import java.util.Scanner;
import java.util.Random;


public class Main {

    public static void main(String[] args) {
	// write your code here


      /*  1. Napisać program, który generuje całkowite liczby pseudolosowe z zakresu (-50; 100] tak długo, aż
        zostanie wylosowana liczba 0. W wyniku wykonania programu (bez wykorzystania tablic), powinny na
        konsoli zostać wyświetlone:
        a) największa i najmniejsza z wylosowanych liczb oraz średnia liczb parzystych dodatnich.
                b) ciąg liczb Fibonacciego o wartościach mniejszych niż iloczyn wartości bezwzględnych drugiej co
        do wielkości i najmniejszej liczby wylosowanej w pierwszym kroku.
        */



        System.out.println("Zadanie 1.1");
        Scanner in=new Scanner(System.in);
        //System.out.println("Podaj liczbe");
        //int l=in.nextInt();
        //System.out.println(l);

        Random r =new Random();
        int los;
        int min=0;

        int drugamax=0;
        int max=0;
        float srednia=0;
        int suma=0;
        int ileliczb=0;

        do
        {    los=r.nextInt(149)-50;  //1 do 10   r.nextInt(max-min) +min-
            System.out.println(los);
            if(los%2==0 && los>0 )
            {
                suma=suma+los;
                ileliczb++;
                srednia=(float)suma/ileliczb;
            }
            //mintemp=los;
            if(los<min)
            {
                min=los;
            }


            if(los>max)
            {  drugamax=max;
                max=los;
            }






        } while(los!=0);


        int dodatniamin=min;
        int dodatniamaxdruga=drugamax;
        if(min<0)
        {
            dodatniamin=min*(-1);
        }
        if(dodatniamaxdruga<0)
        {
            dodatniamaxdruga=drugamax*(-1);
        }

        int iloczyn=dodatniamaxdruga*dodatniamin;
        System.out.println("Ciag fibbobaciego mniejszy od: "+iloczyn);
        int fib=1;
        int fibb=1;
        int tempfib=0;
        int ile=0;
        while(fib<iloczyn)
        {
            if(ile==0 )
            {    fib=0;
                ile++;

            }
            else
            {
                if(ile==1)
                {
                    fib=1;
                    System.out.println(fib);
                    ile++;
                }
                else
                {
                    fibb=tempfib;
                    tempfib=fib;
                    fib=fib+fibb;

                    ile++;
                    if(fib<iloczyn)
                        System.out.println(fib);
                }
            }

        }






        System.out.println("Srednia wynosi: "+srednia);
        System.out.println("Min wynosi: "+min);
        System.out.println("2 Max wynosi: "+drugamax);
        System.out.println("Max wynosssi: "+max);











    }
}
