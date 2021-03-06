package com.company;

import java.util.List;
import java.util.Scanner;
import java.io.*;




//public static void szukaj(String nazwaPlikWe, String nazwaPlikWy,
//String slowo)
//której zadaniem jest znalezienie wszystkich wierszy w pliku, które zawierają szukane słowo. Wszystkie wiersze, które zawierają słowo powinny zostać zapisane w
//pliku wynikowym wraz z nr wiersza (z pierwszego pliku). Nazwa pierwszego pliku
//zapamiętana jest w parametrze nazwaPlikWe, nazwa pliku wynikowego podana
//jest w parametrze nazwaPlikWy, natomiast szukane słowo w parametrze slowo.
//Przykład - plik wejściowy:
//Ala ma jutro egzamin z biologii.
//Jan myje auto.
//Eh, jutro kolejny egzamin.
//Nie lubie polityki.
//Jeżeli szukanym słowem byłoby ”egzamin”, to plik wynikowy powinien wyglądać
//następująco:
//1: Ala ma jutro egzamin z biologii.
//3: Eh, jutro kolejny egzamin.


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
