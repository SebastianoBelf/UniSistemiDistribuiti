
package edu.unict.tswd.SocketThreadScaricati.Shared;
import java.io.*;
import java.util.*;

public class Shared{
    private int m;
	private Random rand;
	
	public Shared(){
    	rand=new Random();
		m=0;
  	}

  public synchronized void setShared(int m){
		this.m=m;
	}
  public synchronized int getShared(){
		return m;
	}

  public synchronized void fun_1(){
		int mtemp=m;
		System.out.println("T1 -> " + m);
		m=rand.nextInt(10);
	  System.out.println("T1 ha generato il numero " +m);
		if(mtemp%2!=0){
			System.out.println("T1 si mette in attesa");
			try{
				wait();
			}
			catch(InterruptedException e){}
		}
	}
  public synchronized void fun_2(){
		int mtemp=m;
		System.out.println("\t\t\tT2 -> " + m);
		m=rand.nextInt(10);
	  System.out.println("T2 ha generato il numero " +m);
		if(mtemp%2==0){
			System.out.println("\t\t\tT2 si mette in attesa");
			try{
				wait();
			}
			catch(InterruptedException e){}
		}
	}
  public synchronized void fun_3(){
		System.out.println("\t\t\t\t\tT3 in azione");
		notifyAll();
	}

}
