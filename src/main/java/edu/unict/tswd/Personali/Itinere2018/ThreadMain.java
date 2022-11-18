package edu.unict.tswd.Personali.Itinere2018;

public class ThreadMain {

    public static void main(String[] a) {
        SharedArea sa = new SharedArea();
        ThreadTP t0 = new ThreadTP(sa);
        ThreadTD t1 = new ThreadTD(sa);
        t0.setName("pari");
        t1.setName("dispari");

        t0.start();
        t1.start();

    }
}
