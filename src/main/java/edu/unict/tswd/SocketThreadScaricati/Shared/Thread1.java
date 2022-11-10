package edu.unict.tswd.SocketThreadScaricati.Shared;

public class Thread1 extends Thread{
	private Shared m;

	public Thread1(Shared m){
		this.m=m;
		this.start();
	}
	public void run(){

		for(;;){
      			m.fun_1();
			try{
				Thread.sleep(300);
			}
			catch(InterruptedException e){}
		}
	}
}
