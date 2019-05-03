package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;
import  java.io.*;


public class Main {


    public static void emerytura() throws IOException {
        String nazwa="plikWE.txt";
        String kobiety="kobiet.txt";
        String mezczyzni="mezczyzni.txt";

        Scanner in=null;
        PrintWriter writeMEN=null;
        PrintWriter writeKOB=null;
        try {

            in=new Scanner(new BufferedReader(new FileReader(nazwa)));
            writeKOB=new PrintWriter(new BufferedWriter(new FileWriter(kobiety,false)));
            writeMEN=new PrintWriter(new BufferedWriter(new FileWriter(mezczyzni,false)));

            String imie="",nazwisko="",plec="";
            int wiek=0;
            int ileDoEmerytury;
            String patt="[M,K]";
            String pattslowo="[a-zA-Z]*";


            while (in.hasNextLine())
            {

                imie=in.next(pattslowo);
                nazwisko=in.next();
                plec=in.next(patt);
                wiek=in.nextInt();

                ileDoEmerytury=65-wiek;
                System.out.println("imie: "+imie+" Nazwisko: "+nazwisko+" Plec: "+plec+" Wiek EM: "+ileDoEmerytury);


                if(plec.equals("M"))
                {
                    writeMEN.println(imie+" "+nazwisko+" "+plec+" "+ileDoEmerytury);

                }else
                {
                    writeKOB.println(imie+" "+nazwisko+" "+plec+" "+ileDoEmerytury);


                }


            }





        }catch (FileNotFoundException f)
        {
            RandomAccessFile r =new RandomAccessFile(nazwa,"rw");
            RandomAccessFile m =new RandomAccessFile(mezczyzni,"rw");
            RandomAccessFile k =new RandomAccessFile(kobiety,"rw");
        }
        catch (InputMismatchException f)
        {
            System.out.println("Błędne dane "+f.getMessage());
        }

        finally {

            if(in!=null)
                in.close();

            if(writeKOB!=null)
                writeKOB.close();

            if(writeMEN!=null)
                writeMEN.close();

        }

    }

    public static void main(String[] args) throws  IOException{

        emerytura();
    }
}
