package edu.unict.tswd.Personali.Itinere2018;

import java.util.Random;

public class ThreadTD extends Thread {
    SharedArea a;
    public ThreadTD(SharedArea aa){
        a = aa;
    }
    @Override
    public void run() {
        Random random = new Random();
        super.run();
        while (true) {
            try {
                sleep(300);

                int val = a.getVal();
                if (val % 2 == 1) {
                    int rr = random.nextInt(10);
                    System.out.println(getName() +" getVal: "+val);
                    a.update(rr);

                    // notify();

                } else {
                    a.update(-1);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}