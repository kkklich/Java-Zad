package com.company;

import  java.io.*;
// Napisać funkcję Kompresuj( String plikWej, String plikWyn ) przetwarzającą plik tekstowy
//(plikWej) na plik obiektów (plikWyn). Przetwarzanie polega na zastąpieniu każdego ciągu
//identycznych znaków pliku tekstowego obiektem zawierającym ten znak i liczbę jego
//kolejnych wystąpień w tym ciągu. Koniec wiersza należy traktować jako pojedynczy znak CR.
//znak liczba
//Przykład:
//a_bbb_cccc
//dd_e_ffffff
//wynik (plik obiektowy z kolejnymi parami danych znak i liczba)::
//a 1 _ 1 b 3 _ 1 c 3 CR 1 d 2 _ 1 e 1 _ 1 f 6

public class Main {

    public static void Odczyt(String nPL,String plikZapisz) throws IOException {


        int maxkond=0;
        String maxdom="";
        RandomAccessFile plik=null;
        RandomAccessFile plikZAP=null;

        try{

            plik =new RandomAccessFile(nPL, "rw");
            plikZAP=new RandomAccessFile(plikZapisz,"rw");

            plik.seek(0);
            long pozycja=0;
            String zdanie="";
            int iloscCR=1;

            while (pozycja<plik.length())
            {
                zdanie=plik.readLine();
                System.out.println(zdanie);
                pozycja=plik.getFilePointer();

                  int iloscIdentycznych=1;
                  String zd="";

                  if(zdanie.length()!=0) {
                      for (int i = 1; i < zdanie.length(); i++) {
                          if (zdanie.charAt(i) == zdanie.charAt(i - 1)) {
                              iloscIdentycznych++;

                          } else {
                              System.out.print(zdanie.charAt(i - 1) + ": " + iloscIdentycznych + "  ");
                                zd=zdanie.charAt(i-1)+": "+iloscIdentycznych+" ";
                              plikZAP.writeUTF(zd);
                              iloscIdentycznych = 1;
                          }

                      }

                      System.out.print("CR: "+iloscCR);
                    iloscCR=1;
                  }else
                  {
                      iloscCR++;
                  }

                System.out.println();

            }




        }catch (EOFException f)
        {
            System.out.println(f.getMessage());
        }
        finally{
            if(plik!=null)
                plik.close();


        }

    }





    public static void main(String[] args)throws IOException, ClassNotFoundException{


        Odczyt("dokument1.txt","PlikZapis.txt");

    }

}