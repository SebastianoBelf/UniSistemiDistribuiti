
package edu.unict.tswd.SocketThreadScaricati.Shared;

public class Main{
  public static void main(String[] args){
    
    Shared m = new Shared();
    
    Thread1 T1 = new Thread1(m);
    Thread2 T2 = new Thread2(m);
    Thread3 T3 = new Thread3(m);
    
    try{
        T1.join();
    }
    catch(InterruptedException e){}
    try{
        T2.join();
    }
    catch(InterruptedException e){}
    try{
        T3.join();
    }
    catch(InterruptedException e){}

  }

}

