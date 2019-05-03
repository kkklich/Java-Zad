package com.company;

import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static  void szukaj(String nazwaplikWe,String nazwaPlikWY, String slowo) throws IOException{

        Scanner in=null;
        PrintWriter writ=null;


        try{

            //Zapisywanie do pliku
            File plik=new File(nazwaPlikWY);
            writ=new PrintWriter(plik);


            writ.println("Słowo to: '"+slowo+"'");

            //Odczytywanie z pliku
            in=new Scanner(new BufferedReader(new FileReader(nazwaplikWe)));




            String [] tab=new String[20];
            String [] WYtab=new String[20];
             int i=0,j=0;


            while(in.hasNextLine())
            {
                tab[i]=in.nextLine();
                if(tab[i].contains(slowo))
                {
                    WYtab[j]=i+" "+tab[i];
                    writ.println(WYtab[j]);
                    j++;
                }

                 System.out.println(tab[i]);
                i++;
            }





        }finally {
            if(in!=null)
            {
                in.close();
            }
            writ.close();
        }



    }

    public static void main(String[] args)throws IOException {

        System.out.println("Zestaw 3, Zadanie 2 ");

        String nazwaplikWe="plikWE.txt";
        String nazwaPlikWY="plikWY.txt";
        String slowo="ma";

        szukaj(nazwaplikWe,nazwaPlikWY,slowo);

    }
}
