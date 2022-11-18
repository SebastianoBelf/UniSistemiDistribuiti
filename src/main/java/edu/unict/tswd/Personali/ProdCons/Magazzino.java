package edu.unict.tswd.Personali.ProdCons;

import java.util.ArrayList;

public class Magazzino {
    ArrayList<Prodotto> prodotti;
    static boolean noProduttori;

    public Magazzino(ArrayList<Prodotto> a){
        prodotti = a;
        noProduttori = false;
    }
    public void addProdotto(int id){
        System.out.println("add:"+id);
        prodotti.stream().filter(e-> e.getId() == id).findFirst().get().addProdotto();
        ShowMagazzino();
    }
    public void removeProdotto(int id){
        System.out.println("remove :"+id);
        prodotti.stream().filter(e-> e.getId() == id).findFirst().get().removeProdotto();
        ShowMagazzino();
    }
    public Prodotto getProdotto(int id){
        return prodotti.stream().filter(e-> e.getId() == id).findFirst().get();
    }
    public int getQuantità(int id){
        ShowMagazzino();
        int a;
        a =  prodotti.stream().filter(e-> e.getId() == id).findFirst().get().getQuantità();
        if(a < 0)System.out.println("La quantità di prodotti di id:"+id+" è negativa");
            return a;
    }
    public void ShowMagazzino(){
        prodotti.forEach(e -> System.out.println("Prodotto :"+e.getId()+"con quantità"+e.getQuantità()));
    }
}

