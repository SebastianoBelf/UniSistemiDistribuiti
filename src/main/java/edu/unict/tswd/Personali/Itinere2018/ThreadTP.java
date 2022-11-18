package edu.unict.tswd.Personali.Itinere2018;

import java.util.Random;

public class ThreadTP extends Thread {
    SharedArea a;
    public ThreadTP(SharedArea aa){
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
                if (val % 2 == 0) {
                    int rr = random.nextInt(10);
                    System.out.println(getName() +" getVal: "+val);
                    a.update(rr);

                } else {
                    a.update(-1);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
