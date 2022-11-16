package edu.unict.tswd.Personali.ProdCons;

public class Produttori extends Thread{

    Magazzino magazzino;
    int idProdotto;
    int quatità;

    public Produttori(Magazzino _magazzino,int id,int _quatità){
        magazzino = _magazzino;
        idProdotto = id;
        quatità = _quatità;

    }

    @Override
    public void run() {
        super.run();
        for(int i = 0; i < quatità; i++){
            magazzino.addProdotto(idProdotto);
        }
    }
}

