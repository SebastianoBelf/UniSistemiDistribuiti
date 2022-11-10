
package edu.unict.tswd.SocketThreadScaricati.Shared;

public class Thread2 extends Thread{
	private Shared m;

	public Thread2(Shared m){
		this.m=m;
		this.start();
	}
	public void run(){

		for(;;){
      			m.fun_2();
			try{
				Thread.sleep(300);
			}
			catch(InterruptedException e){}
		}
	}
}
