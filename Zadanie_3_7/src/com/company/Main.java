

package com.company;

import java.io.*;
import java.util.Scanner;

// Napisać program, który dla pliku tekstowego o podanej nazwie wyznaczy „wykres” częstości wystąpień małych liter alfabetu angielskiego. Słupki wykresu mają
//zostać utworzone ze znaków gwiazdki ’*’, przy czym długość słupka dla najczęściej
//występującej litery powinna wynosić 50. Dodatkowo dla każdego znaku należy dodatkowo wyświetlić liczbę jego wystąpień.
//Poniżej umieszczono przykładowy wykres wygenerowany dla tekstu „Adventures
//of Huckleberry Finn” M. Twaina dostępnego pod adresem:
//http://www.gutenberg.org/dirs/7/76/76.txt
//a ************************************* 36581
//b ******* 7439
//c ******** 8317
//d ************************ 23754
//e ************************************************** 49084
//f ******** 7914
//g ********** 10733
//h ************************** 26338
//i **************************** 28222

public class Main {


    public static void liczenia()throws IOException, FileNotFoundException   {


        Scanner in=null;
        String nazwaFile="PlikWE.txt";



        try
        {

            in=new Scanner(new BufferedReader(new FileReader(nazwaFile)));


            String slowo="";
            String zdanie="";

            while (in.hasNextLine())
            {

                slowo=in.nextLine();
                zdanie+=slowo;
                //System.out.println(slowo);
            }

            System.out.println("ilosc małych liter: "+zdanie.length());
            System.out.println();

            int ile=0;

            for(int i=97;i<122;i++)
            {

                for(int j=0;j<zdanie.length();j++)
                {
                    if(zdanie.charAt(j)==(char)i)
                    {
                        ile++;
                    }
                }
                System.out.print((char)i+" ");
                for(int k=0;k<ile/1000;k++)
                {
                    System.out.format("*");
                }

                for(int p=0;p<40-(ile/1000);p++)
                {
                    System.out.print(" ");
                }


                System.out.println(ile);
                ile=0;



            }

        }catch (FileNotFoundException f)
        {
            RandomAccessFile r=new RandomAccessFile(nazwaFile,"rw");
        }
        finally {
            if(in!=null)
                in.close();


        }

    }


    public static void main(String[] args)  throws  IOException{

        liczenia();
    }
}
