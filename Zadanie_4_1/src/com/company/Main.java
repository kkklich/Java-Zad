package com.company;

import  java.io.*;

// Dany jest plik, w którym zapisano (w postaci wewnętrznej) kolejne trójki danych tworzące
//informację o budynkach:
//• String nazwDom;
//• int lKondygn;
//• double cena;
//Napisać funkcję zmniejszającą (bezpośrednio w pliku, bez wczytywania całego pliku do
//pamięci) o 10 procent cenę domów
//parterowych i zwracającą jako wartość nazwę domu (nazwDom) o największej liczbie
//kondygnacji (jeśli jest takich więcej, to
//dowolny z nich). Nazwa pliku jest przekazana jako parametr funkcji.

public class Main {

    public static void Odczyt(String nPL) throws IOException {


        int maxkond=0;
        String maxdom="";
        RandomAccessFile plik=null;

        try{
            System.out.println("nazwa  kond  cena");
            plik =new RandomAccessFile(nPL, "rw");

            plik.seek(0);
            long pozycja=0;

            String nazwa=" ";
            int kondygnacje;



           while(pozycja<plik.length())
            {


                nazwa=plik.readUTF();
                    kondygnacje=plik.readInt();
                long pozcena=plik.getFilePointer();
                double cena=plik.readDouble();

                pozycja=plik.getFilePointer();
              String w=nazwa+" "+kondygnacje+" "+cena;
                System.out.format("%s\t%d\t%.2f\n",nazwa,kondygnacje,cena);

                if(kondygnacje==1)
                {
                    long poz=plik.getFilePointer();
                    plik.seek(pozcena);
                    cena=cena*0.9;
                    plik.writeDouble(cena);
                    plik.seek(poz);

                }


                if(kondygnacje>maxkond)
                {
                    maxkond=kondygnacje;
                    maxdom=nazwa;
                }

                // w=nazwa+" "+kondygnacje+" "+cena;
                //System.out.println(w);

            }


            System.out.println("Najwiecej kondygnacji ma: "+maxdom);









        }catch (EOFException f)
        {
            System.out.println(f.getMessage());
        }
        finally{
            if(plik!=null)
                plik.close();


        }

    }


    public static void zapisz(String nPl) throws IOException{
        RandomAccessFile plik = null;
        try{
            plik = new RandomAccessFile(nPl, "rw");
            plik.seek(plik.length());

            plik.writeUTF("Domekparterowy");
            plik.writeInt(1);
            plik.writeDouble(59.1794);

            System.out.println("Zapisano do pliku");

        } finally{
            if(plik!=null)
                plik.close();

        }
    }


    public static void main(String[] args)throws IOException, ClassNotFoundException{

        //zapisz("dokument1.txt");
        Odczyt("dokument1.txt");

    }

}