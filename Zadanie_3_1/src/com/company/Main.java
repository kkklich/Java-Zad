package com.company;

import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, NoSuchElementException{
	// write your code here
        Scanner odczyt;
        File plik=new File("plik.txt");

        odczyt =new Scanner(plik);

        try{


        String [] tekst=new String[10];
        String t="";
        boolean czyjest=false;
        int i=0;
        int iloscSpacji=0;
        int iloscSlow=0;


        String p="";




        while (odczyt.hasNextLine())
        {
            tekst[i]=odczyt.nextLine();
            p=p+' '+tekst[i];


            if(tekst[i]!=" ") {
                for (int j = 0; j < tekst[i].length(); j++) {

                    if (tekst[i].charAt(j) == ' ') {
                        iloscSpacji++;
                    }
                }
            }
           // iloscSpacji++;
            System.out.println(tekst[i]);
            i++;
        }

        System.out.println("--");


        for(int j=0;j<p.length();j++)
        {
            if(p.charAt(j)==' ')
//                iloscSpacji++;

            if(j>0) {
               if (p.charAt(j - 1) != ' ' && p.charAt(j)==' ')
               {
                   iloscSlow++;
               }
            }
        }


   /*      odczyt =new Scanner(plik);

        while(odczyt.hasNextLine()) {


            tekst[i] = odczyt.next();
            iloscSlow++;
        t=t+tekst[i];
        //System.out.println(tekst[i]);
        }
        //System.out.println(t);
*/
        if(p!="")
            czyjest=true;

        if(czyjest==false)
            System.out.println("Plik jest pusty");




        System.out.println("Ilosc znaków: "+p.length());

        iloscSpacji=iloscSpacji+i;
        iloscSlow++;
        System.out.println("Ilosc słów: "+iloscSlow);
        System.out.println("Ilosc białych znaków: "+iloscSpacji);





}catch (NoSuchElementException f)
{
    System.out.println(f.getMessage());
}
finally {
    odczyt.close();
}


        /*FileWriter zapisz=new FileWriter(plik,true);
        zapisz.write("\n"+"Siema");
       zapisz.close();
       */
    }
}
