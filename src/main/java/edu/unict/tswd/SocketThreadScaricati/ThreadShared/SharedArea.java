package edu.unict.tswd.SocketThreadScaricati.ThreadShared;

public class SharedArea {
        public static int shared = 0;
    public synchronized void add(int val){
        try {
            wait(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+"add");
        shared +=val;

    }
    public synchronized int get(){
            notifyAll();
        System.out.println(Thread.currentThread().getName()+"get");
        return shared;

    }
}
