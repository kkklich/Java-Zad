

package com.company;

import java.io.*;
import java.util.Scanner;


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
