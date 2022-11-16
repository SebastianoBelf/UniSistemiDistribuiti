package edu.unict.tswd.Personali.ProdCons;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] a){
        ArrayList<Prodotto> listProdotti = new ArrayList<>(List.of(new Prodotto(0,1),new Prodotto(1,0),new Prodotto(2,0),new Prodotto(3,0),new Prodotto(4,0),new Prodotto(5,0)));
        Magazzino m = new Magazzino(listProdotti);
        Produttori prod0 = new Produttori(m,0,3);
        Produttori prod1= new Produttori(m,1,3);
        Consumatori cons0 = new Consumatori(m,0,2);

        System.out.println("Start thread");
        prod0.start();
        prod1.start();
        cons0.start();

        try {
            prod0.join();
            prod1.join();
            System.out.println("join");
            m.noProduttori = true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }




    }
}
