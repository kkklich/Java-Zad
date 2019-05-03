package com.company;

public class Main {


    private  static boolean anagram(String a, String b)
    {
        String slowo1=a;
        String slowo2=b;
        int dlugosc1=slowo1.length();
        int dlugosc2=slowo2.length();
        int iloscslowo1=0;
        int iloscsslowo2=0;
        boolean czyjest=false;
        boolean czyjestslowo2=false;
        String [] tablica1=new String[dlugosc1+1];
        String [] tablica2=new String[dlugosc2+1];
        int nrtab1=0;
        int nrtab2=0;
        boolean zgodne=false;


        if(dlugosc1==dlugosc2) {
            for (int i = 0; i < dlugosc1; i++) {
                iloscslowo1 = 0;
                iloscsslowo2 = 0;
                czyjest = false;
                czyjestslowo2 = false;

                for (int j = i; j < dlugosc1; j++) {
                    if (slowo1.charAt(i) == slowo1.charAt(j))
                        iloscslowo1++;

                    if (slowo2.charAt(i) == slowo2.charAt(j))
                        iloscsslowo2++;

                }

                for (int k = 0; k < i - 1; k++) {
                    if (slowo1.charAt(k) == slowo1.charAt(i))
                        czyjest = true;


                    if (slowo2.charAt(k) == slowo2.charAt(i))
                        czyjestslowo2 = true;

                }

                if (czyjest == false) {

                    tablica1[nrtab1] = "" + slowo1.charAt(i) + "" + iloscslowo1 + " ";

                    nrtab1++;
                }

                if (czyjestslowo2 == false) {

                    tablica2[nrtab2] = "" + slowo2.charAt(i) + "" + iloscsslowo2 + " ";

                    nrtab2++;
                }
            }

            int ilezgodnosci = 0;
            int rozmiar=0;
            for (int i = 0; i < dlugosc1 - 1; i++) {
                for (int j = 0; j < dlugosc1 - 1; j++) {

                    //rozmiar = tablica1[i].length();
                    //System.out.println(rozmiar);
                    if (tablica1[i] != null && tablica2[j] != null) {
                        if (tablica1[i].charAt(0) == tablica2[j].charAt(0) && tablica1[i].charAt(1) == tablica2[j].charAt(1))
                            ilezgodnosci++;

                    }
                }
            }

            if (ilezgodnosci == dlugosc1 - 1)
                zgodne = true;
        }
        return zgodne;

    }


    public static void main(String[] args) {
	// write your code here

        System.out.println("Program Anagram");


        String slowo1="marta";
        String slowo2="artmaa";

        boolean czyanagram=anagram(slowo1,slowo2);

        System.out.println(czyanagram);

    }
}
