package edu.unict.tswd.Personali.String;

import java.lang.StringBuilder;
public class Stringhe {

    public static void main(String[] a){
        Stringhe s = new Stringhe();
        String prova1 = "c,c";
        stampa("default",prova1);
        String[] aa = prova1.split(",");
        stampa("trim",aa[0]);
        stampa("trim",aa[1]);

        String sss = prova1.concat(",ciao");
        stampa("concat",sss);
        String numeri = "1234";
        int somma = 0;
        for(int i = 0; i < numeri.length();i++){
            somma += (numeri.charAt(i) - '0');
        }
        System.out.println(somma);





    }
    public static void stampa(String comment,String sa){
        System.out.println(comment+": "+sa);
    }


}
