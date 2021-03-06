package com.company;

import java.io.*;
import java.util.Scanner;

//Napisać funkcję, której zadaniem jest odczytanie danych tabelarycznych z pliku
//tekstowego, a następnie zapisanie ich do nowego pliku w postaci kodu HTML.
//Przykład:
//Wejście:
//"Waga" "Wzrost" "BMI" "Nadwaga"
//70 1,8 21,6 "NIE"
//67 1,77 21,39 "NIE"
//85 1,7 29,41 "TAK"
//100 1,92 27,13 "TAK"
//Wynik:
//<html><body>
//<table>
//<tr><td>"Waga"</td><td>"Wzrost"</td><td>"BMI"</td><td>"Nadwaga"
//</td></tr>
//<tr><td>70</td><td>1,8</td><td>21,6</td><td>"NIE"
//</td></tr>
//<tr><td>67</td><td>1,77</td><td>21,39</td><td>"NIE"
//</td></tr>
//<tr><td>85</td><td>1,7</td><td>29,41</td><td>"TAK"
//</td></tr>
//<tr><td>100</td><td>1,92</td><td>27,13</td><td>"TAK"</td></tr>
//</table>
//</body></html>

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
