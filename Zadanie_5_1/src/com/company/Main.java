package com.company;


import java.util.zip.DeflaterOutputStream;

class Pozycja{
    private String nazwaTowaru;
     int ileSztuk;
    double cena;


    public Pozycja(String nazwaTowaru,int ileSztuk,double cena)
    {
        this.nazwaTowaru=nazwaTowaru;
        this.ileSztuk=ileSztuk;
        this.cena=cena;

    }

    public double oblicz()
    {
        //cena=cena*(1-obliczrabat());
        return  ileSztuk*cena;
    }


    public double obliczwartosrabat()
    {
        cena=cena*(1-obliczrabat());
        return  ileSztuk*cena;
    }


    public boolean porownywanie(Pozycja p2)
    {
        if(nazwaTowaru==p2.nazwaTowaru) {
                 return true;
        }
        else
            return false;

    }

    public double obliczrabat()
    {
double rabat=0.0;

        if(ileSztuk>5 && ileSztuk<10)
        {
            rabat=0.05;
        }

        if(ileSztuk>=10 && ileSztuk<=20)
        {
            rabat=0.1;
        }

        if(ileSztuk>20)
            rabat=0.15;




        return  rabat;
    }


@Override
public String toString()
{
    return String.format("%s %20s %f zł %4d szt. %10f zł  rabat: %f  %f zł",nazwaTowaru,"",cena,ileSztuk,oblicz(),obliczrabat()*100,obliczwartosrabat());
}

}




//classa Zamowinie

class Zamówienie {

    Pozycja[] pozycje;
    int ile_dodanych = 0;
    int maksRozmiar;


    public Zamówienie() {

        maksRozmiar = 10;
        pozycje=new Pozycja[maksRozmiar];
    }

    public Zamówienie(int maksRozmiar) {
        this.maksRozmiar = maksRozmiar;
        pozycje=new Pozycja[maksRozmiar];
    }


    public void Dodaj(Pozycja p) {


        if(ile_dodanych<maksRozmiar) {



            boolean czyjest=false;

            for(int i=0;i<ile_dodanych;i++) {

                if(p.porownywanie(pozycje[i])==true)
                {
                    pozycje[i].ileSztuk+=p.ileSztuk;
                    czyjest=true;
                    break;
                }


            }


            if(czyjest==false) {
                pozycje[ile_dodanych++] = p;
                //System.out.println("dodano pozycje");
            }
            else
            {
                //System.out.println("Pozycja juz istnieje");
            }
        }
    }



    public double obliczwartosc() {
        double wartosc = 0;
        for (int i = 0; i < ile_dodanych; i++) {

            wartosc += pozycje[i].oblicz();

        }
        return wartosc;
    }


    @Override
    public String toString() {

        String dane="";
        for (int j = 0; j < ile_dodanych; j++) {
            dane+=pozycje[j].toString()+"\n";

        }
        return dane+"Razem: "+obliczwartosc()+" zł";
    }



    public void usunPozycje(int indeks)
    {

        for(int i=indeks;i<ile_dodanych-1;i++)
        {
            pozycje[i]=pozycje[i+1];

        }

        ile_dodanych--;

    }



//dodac Scanera
    public void edytujPozycje(int indeks,String nazwaT,int ileszt,double cena)
    {

        Pozycja pp=new Pozycja(nazwaT,ileszt,cena);
     pozycje[indeks]=pp;


    }



}



public class Main {

    public static void main(String[] args) {


        Pozycja p =new Pozycja("chleb",5,2.4);
        Pozycja p2=new Pozycja("jajko",4,0.6);
        Pozycja p3=new Pozycja("parówki",8,1.2);
        Pozycja p4=new Pozycja("pomidor",12,0.9);


      /*  System.out.println( p.toString());
        System.out.println( p2.toString());
        System.out.println(p3.toString());
        System.out.println(p4.toString());
*/
        Zamówienie z=new Zamówienie();

        z.Dodaj(p);
        z.Dodaj(p2);
        z.Dodaj(p3);
        z.Dodaj(p4);
        z.Dodaj(p);


        System.out.println("\n Zamównie \n");
        //System.out.println(z.toString());
        //System.out.println("razem: "+ z.obliczwartosc()+" zł");

        z.edytujPozycje(2,"jogurt",23,1.4);
        //z.usunPozycje(2);
        System.out.println();
        System.out.println("asas");

       // z.dodajPozycje("chleb",5,2.4);
        System.out.println(z.toString());
    }
}
