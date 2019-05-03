package com.company;


import java.util.Scanner;
import java.io.*;

public class Main {

    public static void szyfruj()throws IOException, NullPointerException{

        String nazwaWE="plikWE.txt";
        String nazwaWY="_"+nazwaWE;
        Scanner in=null;
        PrintWriter writ=null;
        try{
            in=new Scanner(new BufferedReader(new FileReader(nazwaWE)));

            String slowo;
            char zamienione=' ';
            int liczba=2,j=0;
            String [] tablica=new String[20];



            while (in.hasNext())
            {
                slowo=in.next();
                String zaszyfrowane="";

                for(int i=0;i<slowo.length();i++)
                {

                        if ((int) slowo.charAt(i) + liczba > 122) {
                            zamienione = (char) ((int) slowo.charAt(i) + liczba - 26);

                        } else {
                            zamienione = (char) ((int) slowo.charAt(i) + liczba);
                        }

                    System.out.println(slowo.charAt(i)+": "+(int)slowo.charAt(i)+"  "+zamienione+": "+((int)slowo.charAt(i)+liczba-26));
                    zaszyfrowane=zaszyfrowane+zamienione;

                }
                tablica[j]=zaszyfrowane;
                j++;
                System.out.println(zaszyfrowane);
//                writ.println(zaszyfrowane);


            }

            File plik=new File(nazwaWE);
            writ=new PrintWriter(plik);



            for(int k=0;k<j;k++)
            {
                writ.println(tablica[k]);
            }



        }catch (FileNotFoundException f)
        {
            RandomAccessFile r= new RandomAccessFile(nazwaWE,"rw");
        System.out.println(f.getMessage());
        }
        finally {
            if(in!=null)
                in.close();
         writ.close();

        }


    }


    public  static void odszyfruj() throws  IOException    {




        String nazwaWE="plikWE.txt";
        String nazwaWY="_"+nazwaWE;
        Scanner in=null;
        PrintWriter writ=null;
        try{
            in=new Scanner(new BufferedReader(new FileReader(nazwaWE)));

            String slowo;
            char zamienione=' ';
            int liczba=2,j=0;
            String [] tablica=new String[20];



            while (in.hasNext())
            {
                slowo=in.next();
                String zaszyfrowane="";

                for(int i=0;i<slowo.length();i++) {

                        if ((int) slowo.charAt(i) - liczba <97) {
                            zamienione = (char) ((int) slowo.charAt(i) - liczba + 26);

                        } else {
                            zamienione = (char) ((int) slowo.charAt(i) - liczba);
                        }

                    System.out.println(slowo.charAt(i) + ": " + (int) slowo.charAt(i) + "  " + zamienione + ": " + ((int) zamienione));

                    zaszyfrowane=zaszyfrowane+zamienione;

                }
                tablica[j]=zaszyfrowane;
                j++;
                System.out.println(zaszyfrowane);
//                writ.println(zaszyfrowane);


            }

            File plik=new File(nazwaWE);
            writ=new PrintWriter(plik);



            for(int k=0;k<j;k++)
            {
                writ.println(tablica[k]);
            }



        }catch (FileNotFoundException f)
        {
//            RandomAccessFile r= new RandomAccessFile(nazwaWE,"rw");
  //          RandomAccessFile w= new RandomAccessFile(nazwaWY,"rw");
            System.out.println(f.getMessage());
        }
        finally {
            if(in!=null)
                in.close();

            if(writ!=null)
            writ.close();

        }
    }


    public static void main(String[] args) throws  IOException{

       //szyfruj();
        odszyfruj();

    }
}
