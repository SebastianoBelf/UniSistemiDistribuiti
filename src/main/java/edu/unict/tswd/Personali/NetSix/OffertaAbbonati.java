package edu.unict.tswd.Personali.NetSix;

public class OffertaAbbonati {
    String[] nome;
    int[] nEpisodi;

    public OffertaAbbonati(){
        nome =  new String[]{"Serie1", "Serie2", "Serie3", "Serie4", "Serie5", "Serie6"};
        nEpisodi = new int[]{1,2,3,4,5,6};

    }

    public String getDisponibilita(String s){
        String[] info = s.trim().split(",");
        for(int i = 0; i < 6; i++){
            if(nome[i].equals(info[0]) && nEpisodi[i] >= Integer.parseInt(info[1])){
                return "Disponibile";
            }
        }
        return "ComingSoon";
    }
}
