package com.company;



class Czas{

private int godziny;
private int minuty;

public Czas(int godziny,int minuty)
{
    if(minuty>60)
    {
        this.godziny=godziny+minuty/60;
        int z=minuty-((minuty/60)*60);
        this.minuty=z;
    }
    else {
        this.godziny = godziny;
        this.minuty = minuty;
    }
}

public Czas(String czasSlowo)
{
//12 h 48 min
    String [] liczby=new String[10];
    int[] dane=new int[10];
    int j=0;

    liczby=czasSlowo.split(" ");

    boolean czyliczba=false;

    for(int i=0;i<liczby.length;i++) {
       // System.out.println(liczby[i]);


        try {

            dane[j]=Integer.parseInt(liczby[i]);
            czyliczba = true;

        } catch (NumberFormatException f) {
            czyliczba = false;
        }

        if(czyliczba==true) {

         //System.out.println(dane[j]+" Jest liczbą");
         if(j==0)
             godziny=dane[j];

         if(j==1)
             minuty=dane[j];


            j++;
        }

    }
}


    public void toSString()
    {

        System.out.println(godziny+" h "+minuty+" min");


    }


    public Czas dodaj(Czas t)
    {
        minuty+=t.minuty;
        if(minuty>60) {
         godziny+= minuty/60;
         minuty=minuty-((minuty/60)*60);
        }

        godziny+=t.godziny;

        Czas tt=new Czas(minuty,godziny);
        return tt;

    }

    public Czas usun(Czas t) {

         if((godziny*60+minuty)>(t.godziny*60+minuty))
        {


        if(t.minuty>minuty)
        {
            godziny-= ((minuty-t.minuty)/60)+1;
            minuty=60+(minuty-t.minuty);

        }else
        {
            minuty = minuty - t.minuty;
        }
        godziny = godziny - t.godziny;
            Czas tt=new Czas(minuty,godziny);
            return tt;
        }else
         {
             System.out.println("nie można odejmować mniejszego czasu od mniejszego");
             return null;

         }


    }


    public Czas pomnoz(int n)
    {
        minuty*=n;
        godziny*=n;

        if(minuty>60)
        {
            godziny+= minuty/60;
            minuty=minuty-((minuty/60)*60);
        }

        Czas tt=new Czas(minuty,godziny);
        return tt;
    }


    public static  Czas sumuj(Czas[] tab,int n)
    {
        int min=0,godz=0;

        for(int i=0;i<n;i++) {
            min += tab[i].minuty;
            godz+=tab[i].godziny;
        }

        if(min>60)
        {
            godz+= min/60;
            min=min-((min/60)*60);
        }

        System.out.println(godz+" h "+min+" min");
        Czas tt=new Czas(min,godz);
        return tt;
    }

}


public class Main {

    public static void main(String[] args) {
	// write your code here
    Czas t1=new Czas("12 godzinyhh  34 min");
    Czas t2=new Czas(2,122);

    t1.toSString();
    t2.toSString();
   // t1.dodaj(t2);
   // t1.toSString();
    t2.usun(t1);
    //t2.toSString();
      //  t1.pomnoz(2);
        t1.toSString();

    Czas[] tab={t1,t2};
    Czas.sumuj(tab,2);

    }
}
