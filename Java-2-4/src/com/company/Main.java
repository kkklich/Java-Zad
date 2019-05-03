package com.company;

public class Main {



    private static void firstlast(String s,char c)
    {

        System.out.println("Słowo pierwotne: "+s);
        char znak=c;
        String slowo=s;
        int dl=slowo.length();
        int min=dl;
        int max=0;
        int roznica=0;

        for(int i=0;i<dl;i++)
        {
            if( slowo.charAt(i)==znak)
            {
                if(i>max)
                    max=i;

                if(i<min)
                    min=i;

            }
        }

        System.out.print("Słowo: ");
        for(int i=min+1;i<max;i++)
        {
            System.out.print(slowo.charAt(i));
        }

        roznica=max-min-1;
        if(roznica<0)
            roznica=-1;
        System.out.println("");

        System.out.println("Odległość: "+roznica);

    }



    public static void main(String[] args) {
	// write your code here

        String slowo="cccccabbbbdd";
        char znak='a';

        firstlast(slowo,znak);

    }
}
