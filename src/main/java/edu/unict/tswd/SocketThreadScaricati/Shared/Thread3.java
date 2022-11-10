package edu.unict.tswd.SocketThreadScaricati.Shared;

public class Thread3 extends Thread{
	private Shared m;

	public Thread3(Shared m){
		this.m=m;
		this.start();
	}
	public void run(){

		for(;;){
      			m.fun_3();
			try{
				Thread.sleep(300);
			}
			catch(InterruptedException e){}
		}
	}
}
