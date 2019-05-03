package com.company;


import java.util.Arrays;


public class Main {


    private static void sortuj(String slowo)
    {
        String zdanie=slowo;
        int ileslow=0;
        zdanie=zdanie.replaceAll(",","");




        for(int i=0;i<zdanie.length();i++)
        {
            if(zdanie.charAt(i)==' ')
                ileslow++;
        }
        ileslow++;




        String slowa[] = new String[ileslow];
        slowa=zdanie.split(" ");
        int suma=0;
        double srednia=0;

        for(int i=0;i<ileslow;i++)
        {
            slowa[i]=slowa[i].toLowerCase();
            suma=suma+slowa[i].length();

        }

        srednia=(double)suma/ileslow;

        Arrays.sort(slowa);
        for(String s:slowa)
        {
            System.out.print(s+" ");
        }
        System.out.println();
        System.out.println("Srednia wynosi: "+srednia);

    }

    public static void main(String[] args) {
	// write your code here

        String zdanie="Aleksandra Joanna, Agnieszka";
        sortuj(zdanie);

    }
}
