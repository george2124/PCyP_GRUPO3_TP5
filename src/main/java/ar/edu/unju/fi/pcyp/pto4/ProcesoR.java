package ar.edu.unju.fi.pcyp.pto4;

import java.util.concurrent.Semaphore;

public class ProcesoR extends Thread {
	private final Semaphore semaforo; 
	
	
	public ProcesoR(Semaphore semaforo) {
		this.semaforo = semaforo;
	}


	public void run() {
         
        	  	System.out.println("R1: ejecutando");
        	  
        	  	// Espera hasta que R termine R1
        	  	semaforo.release();

        	  	System.out.println("R: puede continuar");

     }
}
