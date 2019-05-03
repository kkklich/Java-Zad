package com.company;

import  java.io.*;


public class Main {

    public static void Odczyt(String nPL,String plikZapisz) throws IOException {


        int maxkond=0;
        String maxdom="";
        RandomAccessFile plik=null;
        RandomAccessFile plikZAP=null;

        try{
            System.out.println("nazwa  kond  cena");
            plik =new RandomAccessFile(nPL, "rw");
            plikZAP=new RandomAccessFile(plikZapisz,"rw");

            plik.seek(0);
            long pozycja=0;

            String nazwa=" ";
            int kondygnacje;
            long poz=0;


            while(pozycja<plik.length())
            {


                nazwa=plik.readUTF();
                kondygnacje=plik.readInt();
                long pozcena=plik.getFilePointer();
                double cena=plik.readDouble();

                pozycja=plik.getFilePointer();
                String w=nazwa+" "+kondygnacje+" "+cena;
                System.out.format("%s\t%d\t%.2f\n",nazwa,kondygnacje,cena);

                if(kondygnacje==2)
                {

                    plikZAP.seek(plikZAP.length());
                    cena=cena*0.15;
                    plikZAP.writeUTF(nazwa);
                    plikZAP.writeDouble(cena);


                }


                if(kondygnacje>maxkond)
                {
                    maxkond=kondygnacje;
                    maxdom=nazwa;
                }


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

            plik.writeUTF("Dom5");
            plik.writeInt(2);
            plik.writeDouble(642.648);

            System.out.println("Zapisano do pliku");

        } finally{
            if(plik!=null)
                plik.close();

        }
    }


    public static void main(String[] args)throws IOException, ClassNotFoundException{

//        zapisz("dokument1.txt");
        Odczyt("dokument1.txt","PlikZapis.txt");

    }

}