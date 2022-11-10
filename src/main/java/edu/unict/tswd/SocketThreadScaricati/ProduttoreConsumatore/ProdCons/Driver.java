package edu.unict.tswd.SocketThreadScaricati.ProduttoreConsumatore.ProdCons;

import edu.unict.tswd.thread.hellothread.myRunnable;

import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();
        ProdCons prodCons = new ProdCons(5);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        threads.add(new Producer(prodCons, 3));
        threads.add(new Producer(prodCons, 3));
        threads.add(new Producer(prodCons, 3));
        threads.add(new Producer(prodCons, 3));

        threads.add(new Consumer(prodCons));
        threads.add(new Consumer(prodCons));

        threads.forEach(thread -> thread.start());

        // Mi metto in attesa dei soli produttori.
        threads.forEach(thread -> {
            if (thread instanceof Producer) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Dopo che tutti i produttori hanno finito, notifico i consumatori.
        // Questi consumeranno tutti i prodotti e dopo termineranno.
        threads.forEach(thread -> {
            if (thread instanceof Consumer)
                thread.interrupt();
        });

    }
}
