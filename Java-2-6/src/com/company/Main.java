package com.company;


import  java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("Program wczytuje od użytkownika liczbę, a następnie odwraca ją.");


        Scanner scan=new Scanner((System.in));
        System.out.print("Podaj liczbę: ");
        int liczba=scan.nextInt();
        int potega;
        int b=0;



            String a=Long.toString(liczba);
            int ile=a.length();

        int[] cyfra=new int[ile+1];

            for (int i = ile; i > 0; i--)
            {   potega = 1;
                for (int k = 1; k < i; k++)
                {
                    potega = potega * 10;
                }

                cyfra[i]= (liczba / (potega)) - b;
                b = (liczba / (potega)) * 10;

            }


            int odwrocona=0;
            for(int i=1;i<=ile;i++)
            {
                potega = 1;
                for (int k = i; k < ile; k++)
                {
                    potega = potega * 10;
                }
                odwrocona=odwrocona+(cyfra[i]*potega);

             //  System.out.println( cyfra[i]);
            }


            int suma=liczba+odwrocona;
            System.out.println("Odwrócona liczba wynosi: "+odwrocona);
             System.out.println("Suma dwóch liczb wynosi: "+suma);

    }
}
