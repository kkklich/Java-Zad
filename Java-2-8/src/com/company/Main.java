package com.company;

import java.util.Scanner;

public class Main {


    private static  void akronim(String slowo)
    {

        String wyraz=slowo;
        String [] tablica=new String[10];
        String akro="";
        int nr=0;
        char litera=' ';


        tablica=wyraz.split(" ");

        for(int i=0;i<tablica.length;i++)
        {
            if(tablica[i]!=null) {

                litera= tablica[i].charAt(0);

                if ((int) tablica[i].charAt(0) >= 97 && (int) tablica[i].charAt(0) <= 122) {
                    nr = tablica[i].charAt(0) - 32;
                    litera = (char) nr;

                }

                akro=akro+""+litera;
            }

        }
        System.out.println("Akronim to: "+akro);

    }

    public static void main(String[] args) {
	// write your code here

        Scanner sca=new Scanner((System.in));
        System.out.println("Program Akronim");
        System.out.print("Podaj zdanie: ");

        String slowo=sca.nextLine();

        akronim(slowo);


    }
}
