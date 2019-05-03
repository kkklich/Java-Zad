package com.company;




public class Main {



    private static void sortuj(String a)
    {

        System.out.println("Sortowanie słów");

        String zdanie=a;
        String nowezdanie="";
        int ilewyrazow=0;
        int nrtabeli=0;

        System.out.println(zdanie);
        zdanie=zdanie.replace(",","");


        for(int i=1;i<zdanie.length();i++) {
            if (zdanie.charAt(i) == ' ' && zdanie.charAt(i - 1) != ' ')
                ilewyrazow++;

        }

        ilewyrazow++;


        //Rozdzielania zdania na słowa ' '
        String [] tablica=new String[ilewyrazow];
        tablica=zdanie.split(" ");

        //Zapamietywanie gdzie jest duża litera

        String [] tabelkaduza=new String[zdanie.length()];
        String zmienna="";

        for(int j=0;j<ilewyrazow;j++) {
            //      System.out.println(tablica[j]);
            for (int i = 0; i < tablica[j].length(); i++) {

                if ((int) tablica[j].charAt(i) >= 65 && (int) tablica[j].charAt(i) <= 90) {
                    zmienna=tablica[j].toLowerCase();
                    tabelkaduza[nrtabeli] = zmienna+" "+i;
                    nrtabeli++;
                }

            }
            tablica[j]=tablica[j].toLowerCase();
            // System.out.println(tablica[j]);
        }


        for(int i=0;i<nrtabeli;i++)
        {
            //  System.out.println(tabelkaduza[i]);
        }



        String temp="";

        int iloscslow=tablica.length;
        int dlugoscwyrazu=0;

        //Sortowanie słów
        for(int k=0;k<iloscslow;k++) {
            for(int i=1;i<iloscslow;i++)
            {

                if(tablica[i-1].length()<tablica[i].length())
                {
                    dlugoscwyrazu=tablica[i-1].length();
                }
                else
                {
                    dlugoscwyrazu=tablica[i].length();
                }

                for (int j = 0; j < dlugoscwyrazu; j++) {
                    if ((int) tablica[i - 1].charAt(j) > (int) tablica[i].charAt(j)) {
                        temp = tablica[i - 1];
                        tablica[i - 1] = tablica[i];
                        tablica[i] = temp;

                        break;
                    } else {
                        if (tablica[i - 1].charAt(j) < tablica[i].charAt(j)) {
                            break;
                        }
                    }
                }
            }

        }


        //Powiekszanie liter, ktore wczesniej byly duze
        int z;
        int nr;
        char p;
        String q="";
        String imie;
        int spacja=1;
        StringBuilder strin;
        int licznik=0;


        for(int i=0;i<nrtabeli;i++)
        {

            for (int j = 1; j < tabelkaduza[i].length(); j++) {

                if (tabelkaduza[i].charAt(j) == ' ')
                    spacja=j;
            }


            imie=tabelkaduza[i].substring(0,spacja);
            q=tabelkaduza[i].substring(spacja+1,tabelkaduza[i].length());

            nr=Integer.parseInt(q);
            q = "";

            for(int j=0;j<ilewyrazow;j++)
            {
                if (imie.equals(tablica[j].toLowerCase()))
                {
                    licznik++;
                    strin=new StringBuilder(tablica[j]);
                    z = (int) tablica[j].charAt(nr);
                    z = z - 32;
                    p = (char) z;
                    strin.setCharAt(nr, p);
                    tablica[j]=strin.toString();

                }
            }
        }


        zdanie="";
        double srednia=0;
        int suma=0;
        for(String s: tablica)
        {       suma=suma+s.length();
            zdanie=zdanie+s+" ";
        }

        srednia=(double)suma/ilewyrazow;


        System.out.print(zdanie);
        System.out.println("Srednia: "+String.format("%2.2f",srednia));
    }


    public static void main(String[] args) {
	// write your code here
        String zdanie="Ala ma kota i dwie agrafki";
        sortuj(zdanie);

    }
}
