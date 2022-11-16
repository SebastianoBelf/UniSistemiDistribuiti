package edu.unict.tswd.Personali.ProdCons;

public class Prodotto {
    int id;
    int quantità;

    boolean flag = false;

    public Prodotto(int _id, int _quatità){
        id = _id;
        quantità = _quatità;
    }
    public synchronized void addProdotto(){
        if(quantità <= 0) notify();
        quantità++;
    }
    public boolean getFlag(){
        return  flag;
    }
    public synchronized void removeProdotto(){
        if(quantità < 0) {System.out.println("removeProdotto id:"+id+"con quatità negativa");
            try {
                if(Magazzino.noProduttori == true) flag = true;
                wait(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        quantità--;
    }

    public int getId() {
        return id;
    }

    public int getQuantità() {
        if(quantità > 0) System.out.println("Vuole il prodotto di id:"+id+"di pos:"+quantità);
        return quantità;
    }
}
