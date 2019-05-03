package com.company;

public class Main {


    private char aChar;

    private static  String[] spli2(char [] znaczek, String slowo1)
    {
/*3. Napisać funkcję split2, która działa podobnie, jak funkcja split (pozwalającej na podzielenie łańcucha znaków na pod
łańcuchy (względem podanego znaku / ciągu znaków) i zwrócenie ich w postaci tablicy łańcuchów znaków), ale tym
razem podział łańcucha dokonywany może być względem wielu znaków / ciągów znaków (przekazanych w tablicy
znaków). Przykładowa deklaracja funkcji:
String[] split2(String str, String[] tStr);*/



        char [] tabzank=znaczek;


        int dltabznak=0;

        String slowo=slowo1;
        int dlugosc=slowo.length();
        int ileznakow=0;
        String [] tablica=new String[10];
        String temptekst="";
        String znak="";
        boolean czyjestzank=false;


        for(int i=0;i<dlugosc;i++)
        {
            String wyraz=""+slowo.charAt(i);


            for(int j=0;j<tabzank.length;j++) {
                znak=""+tabzank[j];
                if(znak!=null) {
                    if (wyraz.equals(znak)) {
                        ileznakow++;
                        temptekst = "";
                        czyjestzank=true;
                    }
                }
            }
                if(czyjestzank==false) {
                    temptekst = temptekst + slowo.charAt(i);
                    tablica[ileznakow] = temptekst;

                }
                czyjestzank=false;

        }
            return  tablica;


    }


    public static void main(String[] args) {
	// write your code here


        char []tabzank=new char[12];
        tabzank[0]=' ';
        tabzank[1]='k';
        tabzank[2]='z';
        String[] tablica=new String[100];
        String slowo="Czesc jestem krzys";

        tablica=spli2(tabzank,slowo);

        for(int i=0;i<tablica.length;i++)
        {
            if(tablica[i]!=null)
            System.out.println(tablica[i]);
        }

    }
}
