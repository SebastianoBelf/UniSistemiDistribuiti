package edu.unict.tswd.SocketThreadScaricati.ThreadShared;

import java.util.Random;

public class GenerateNumber extends Thread{
 int pari;
 int count;

    SharedArea area;

    public GenerateNumber(boolean pari,SharedArea area) {
        super();
        this.pari = pari? 0 : 1;
        count = 0;
        setName(pari? "pari":"dispari");
        this.area = area;
    }

    int generate(){
        int a = new Random().nextInt(10);
        return (checkParam(a)) ? a : a +1 ;
    }
    private boolean checkParam(int var){
        return ((var & 1 ) == pari);
    }

    @Override
    public void run()  {
        super.run();
        while(true) {

            try {
                sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;

            area.add(generate());
            int val = area.get();

            if(count >= 10 && checkParam(val)) break;
            if(count > 1000) break;

        }
    }
}
