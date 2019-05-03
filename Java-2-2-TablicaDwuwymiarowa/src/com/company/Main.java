package com.company;






public class Main {

    private static int tablicedwu(String [][] tab,String slowo,int liczbaniepodzielna)
    {


        /*2. Napisać funkcję, która w dwuwymiarowej tablicy łańcuchów znaków (podanej przez parametr) znajduje liczbę
wystąpień frazy podanej jako drugi parametr. Jeśli w danej komórce fraza występuje kilkukrotnie, to należy policzyć
każde jej wystąpienie.
Funkcja zwraca liczbę wystąpień frazy. Natomiast dodatkowo wyświetlona zostaje średnią długość łańcuchów
znajdujących się w tabeli oraz łańcuch stworzony z konkatenacji trzech pierwszych* znaków łańcuchów leżących w
kolumnach o indeksach podzielnych przez 5 i niepodzielnych przez liczbę przekazaną przez trzeci parametr funkcji.
* Jeśli łańcuch jest krótszy od 3 znaków, to należy zastosować wszystkie jego znaki.*/


        String fraza = slowo;
        String[][] tablica = tab;
        int liczbaNie=liczbaniepodzielna;


        int iloscwystopien = 0;
        int licznik = 0;


        int wystapienia = 0;
        int suma=0;
        int ilosckomorek=0;
        double srednia=0;
        String noweslowo="";


        for(int k=0;k<tablica.length;k++)
        {

            System.out.print(k+": ");

            for(int p=0;p<tablica.length;p++)
            {
                if(tablica[k][p]!=null)
                {
                    System.out.print(p+": "+tablica[k][p]+"  ");

                    for (int j = 0; j < tablica[k][p].length(); j++) {

                        if (tablica[k][p].charAt(j) == fraza.charAt(0)) {


                            for (int i = j; i < fraza.length() + j; i++) {

                                if(i<tablica[k][p].length()) {

                                    if (tablica[k][p].charAt(i) == fraza.charAt(i - j)) {
                                        iloscwystopien++;
                                       // System.out.print(" " + tablica[k][p].charAt(i)+"  i:"+i);
                                    }


                                    if (iloscwystopien == fraza.length()) {
                                        licznik++;
                                        iloscwystopien = 0;
                                    }
                                }

                            }
                            iloscwystopien=0;



                        }
                    }
                    suma=suma+tablica[k][p].length();
                    ilosckomorek++;

                    if(p%2==0 && p%liczbaNie!=0)
                    {
                        for(int i=0;i<3;i++) {
                                 if(tablica[k][p].length()>i)
                            noweslowo = noweslowo + "" + tablica[k][p].charAt(i);
                        }
                    }



                }

            }

            System.out.println("");

        }

        srednia=(double)suma/ilosckomorek;
        System.out.println();
        System.out.println("nowe slowo: "+noweslowo);

        System.out.format("Srednia długość łańcucha znaków: %.2f",srednia);
        System.out.println();
        return licznik;
    }




    public static void main(String[] args) {
        // write your code here

        String fraza = "ja";
        String[][] tablica = new String[3][3];
        int liczbaniepodzielna=3;

        tablica[0][0] = "siema ja jestem marek  ";
        tablica[0][1] = "siema co tam";
        tablica[0][2] = "Jak";
        tablica[1][0] = "jejeee";
        tablica[1][1] = "siemka";
        tablica[1][2] = "Ja";
        tablica[2][0] = "Tu bylem wczoja";
        tablica[2][1] = "Siema";
        tablica[2][2] = "Jem tu caly czas ja";
        int wystopienia=tablicedwu(tablica,fraza,liczbaniepodzielna);

        System.out.println("Ilosc wystąpnienia słowa '"+fraza+"': "+wystopienia);
    }
}
