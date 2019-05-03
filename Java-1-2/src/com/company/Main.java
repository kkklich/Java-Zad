package com.company;

import  java.util.Random;

public class Main {

    public static void main(String[] args) {



        /*
        * 2. Napisać program, który generuje liczby pseudolosowe z zakresu [-10,0; 10,0] dopóty, dopóki nie zostanie
wylosowana liczba 0,0. Co ważne – liczby powinny być zmiennopozycyjne z dokładnością do pierwszego
miejsca po przecinku (tylko i wyłącznie). W wyniku wykonania programu (bez wykorzystania tablic),
powinna zostać wyświetlona suma co drugiej z wylosowanych liczb (zaczynając od pierwszej) oraz średnia
arytmetyczna liczb dodatnich, podzielnych przez trzy.
Dodatkowo, jeszcze raz powinno zostać wylosowanych (całkowite, zakres [-10, 10]) tyle samo liczb, ile
wylosowano w pierwszej pętli, a w wyniku powinno zostać wyświetlone, ile z tych liczb było większych od
największej liczby wylosowanej w pierwszej pętli oraz różnica pomiędzy średnią arytmetyczną liczb
wylosowanych w pierwszej pętli, a średnią arytmetyczną liczb wylosowanych w drugiej pętli, że
wskazaniem, która pętla miała wyższą średnią.
Uwaga,
nie należy używać (importować) żadnych dodatkowych bibliotek, poza klasą niezbędną do obsługi
losowania liczb. W programie nie należy używać tablic
        


        * */








        System.out.println("Zadanie z 1 ćwiczeń, 2 zadanie");

        Random r=new Random();
        double liczba,cyfra;
        double suma=0.0;
        int numerLiczby=0;
        double sumalicz=0.0;
        double srliczb=0.0;
        int ileliczb3=0;
        double max=-10.0;
        double SumaPierwsza=0.0;



        do{


            liczba=r.nextInt(200)-100;

            liczba=liczba/10;

            if(numerLiczby%2==0) {
                suma = suma + liczba;
            }


            if(liczba>0 && liczba%3==0) {

                sumalicz=sumalicz+liczba;
                ileliczb3++;
            }


            if(liczba>max)
            {
                max=liczba;
            }

            numerLiczby++;
            SumaPierwsza=SumaPierwsza+liczba;


            System.out.println(liczba);



        }while (liczba!=0);


        int liczbaDruga;
        int suma2=0;
        double sredniaDruga;
        int iloscWiekszych=0;

        System.out.println("Druga petla  x"+numerLiczby);
        for(int i=0;i<numerLiczby;i++)
        {

            liczbaDruga=r.nextInt(20)-10;
            suma2=suma2+liczbaDruga;
          System.out.println(liczbaDruga);
            if(liczbaDruga>max)
                iloscWiekszych++;

        }

        sredniaDruga=(double)suma2/numerLiczby;


        if(ileliczb3!=0)
            srliczb=sumalicz/ileliczb3;   //srednia liczb podzielnych przez 3 i wieksze od 0

        double srPierwsza=0.0;

        if(numerLiczby!=0)
            srPierwsza=SumaPierwsza/numerLiczby;



        System.out.println("Suma liczb podzielnych przez 3 i wiekszych od 0 wynosi: "+suma);
        System.out.println("Srednia liczb podzielnych przez 3 i wiekszych od 0 wynosi: "+srliczb);
        System.out.println("Srednia z pierwszej petli wynosi: "+srPierwsza);
        System.out.println("Max: "+max);
        System.out.println("Srednia drugiej petli: "+sredniaDruga);
        if(sredniaDruga>srPierwsza)
            System.out.println("Druga srednia jest wieksza od pierwszej, roznica wynosi: "+(sredniaDruga-srPierwsza));

        if(sredniaDruga<srPierwsza)
            System.out.println("Pierwsza srednia jest wieksza od drugiej, roznica wynosi: "+(srPierwsza-sredniaDruga));

        if(sredniaDruga==srPierwsza)
            System.out.println("Pierwsza srednia jest równa drugiej: "+(srPierwsza-sredniaDruga));


    }
}
