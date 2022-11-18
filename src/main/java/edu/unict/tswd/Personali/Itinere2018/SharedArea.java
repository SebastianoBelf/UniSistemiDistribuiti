package edu.unict.tswd.Personali.Itinere2018;

public class SharedArea {
    int m;

    public SharedArea(){
        m = 0;
    }
    public synchronized int getVal() {
        return m;
    }
    public synchronized void update(int _m) throws InterruptedException {
        if(_m < 0) {wait(); return;}
        m = _m;
        notify();


    }
}
