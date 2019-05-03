package com.company;

import java.io.*;
import java.util.Scanner;


public class Main {


    public static void html()throws IOException, FileNotFoundException   {


        Scanner in=null;
        String nazwaFile="PlikWE.txt";
        String nazwaHTML="Plikhtml.html";
        PrintWriter write=null;

        try
        {

            in=new Scanner(new BufferedReader(new FileReader(nazwaFile)));
            write=new PrintWriter(new BufferedWriter(new FileWriter(nazwaHTML,false)));


            write.println("<HTML> <BODY>");
            write.println("<TABLE>");
            write.println("<tr><td>\"Waga\"</td><td>\"Wzrost\"</td><td>\"BMI\"</td><td>\"Nadwaga\"\n"+"</td></tr>\n");


            double waga=0, wzrost=0,BMI=0;
            String nadwaga;

            while (in.hasNextLine())
            {
                waga=in.nextDouble();
                wzrost=in.nextDouble();
                BMI=in.nextDouble();
                nadwaga=in.next();

                write.println("<tr><td>"+waga+"</td><td>"+wzrost+"</td><td>"+BMI+"</td><td>\""+nadwaga+"\"\n" + "</td></tr>");

            }

            write.println("</body></html>");

        }catch (FileNotFoundException f)
        {
            RandomAccessFile r=new RandomAccessFile(nazwaFile,"rw");
        }
        finally {
            if(in!=null)
                in.close();

            if(write!=null)
                write.close();
        }

    }


    public static void main(String[] args)  throws  IOException{

        html();
    }
}
