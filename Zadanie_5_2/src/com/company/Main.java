package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

class Lista{

private int[] liczby;
private int pojemnosc;
private int rozmiar=0;

 public Lista(int pojemnosc)
 {
     this.pojemnosc=pojemnosc;
     liczby=new int[pojemnosc];
 }

 public void dodajelement(int liczba)
 {
     if(rozmiar>=pojemnosc)
     {
         System.out.println("Tablica jest pełna");
     }
     else {
         liczby[rozmiar++] = liczba;
     }
 }

 public void znajdz(int szukana)
 {
    boolean czyjest=false;

     for(int i=0;i<rozmiar;i++)
     {
         if(liczby[i]==szukana)
         {
             czyjest=true;
             System.out.println("Szukana liczba: "+szukana+" jest na miejscu: "+i);
         }
     }

     if(czyjest==false)
     {
         System.out.println("Nie ma szukanej liczby");
     }

 }


 public void pisz()
 {

     System.out.println("rozmiar: "+rozmiar);
     System.out.println("pojemność: "+pojemnosc);
     for (int i=0;i<rozmiar;i++)
     {
         System.out.println(liczby[i]);
     }

 }


 public void usunpierwsze(int n)
 {

     for(int i=0;i<rozmiar;i++)
     {
         if(liczby[i]==n)
         {
             for(int j=i;j<rozmiar;j++)
             {
                 liczby[j]=liczby[j+1];
             }
             System.out.println("dd:"+ i);
             rozmiar--;
             i--;
             break;

         }
     }

 }


    public void usunwszystkie(int n)
    {

        for(int i=0;i<rozmiar;i++)
        {
            if(liczby[i]==n)
            {
                for(int j=i;j<rozmiar;j++)
                {
                    liczby[j]=liczby[j+1];
                }
                System.out.println("dd:"+ i);
                rozmiar--;
                i--;


            }
        }

    }


    public void odwroc()
    {
        int[] temptab=new int[pojemnosc];
        int j=0;

        for(int i=rozmiar-1;i>=0;i--)
        {
            temptab[j]=liczby[i];
            j++;
        }

        liczby=temptab;

    }


    public void zapisz(String nazwaPlik)
    {

        try {
            File plik = new File(nazwaPlik);
            PrintWriter write = new PrintWriter(plik);


            for(int i=0;i<rozmiar;i++)
            {
                write.println(liczby[i]);

            }

            write.close();
        }
        catch (FileNotFoundException f)
        {
            System.out.println(f.getMessage());
        }

    }




}

public class Main {

    public static void main(String[] args) {


        Lista l1=new Lista(10);
  /*      l1.dodajelement(23);
        l1.dodajelement(1);
        l1.dodajelement(67);
        l1.dodajelement(67);
        l1.dodajelement(54);
        l1.dodajelement(54);
        l1.dodajelement(54);
*/
        for (int i = 0; i < 10; ++i) {
            l1.dodajelement( (16 >> i) );
        }



        l1.znajdz(672);
        l1.pisz();
        //l1.usunpierwsze(67);
        //l1.usunwszystkie(67);

        l1.odwroc();
        l1.pisz();

        l1.zapisz("wyjsciowy.txt");
    }
}
