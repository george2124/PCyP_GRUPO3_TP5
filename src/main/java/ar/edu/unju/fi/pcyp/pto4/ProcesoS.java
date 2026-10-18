package ar.edu.unju.fi.pcyp.pto4;

import java.util.concurrent.Semaphore;

public class ProcesoS extends Thread {
	private final Semaphore semaforo;

    public ProcesoS(Semaphore semaforo) {
		super();
		this.semaforo = semaforo;
	}



	public void run() {

       	 try {
               // Espera bloqueado hasta que R termine R1 y haga el release
               semaforo.acquire();

               System.out.println("S2: ejecutando");

          } catch (InterruptedException e) {
                 Thread.currentThread().interrupt();
            }
     }
    
}