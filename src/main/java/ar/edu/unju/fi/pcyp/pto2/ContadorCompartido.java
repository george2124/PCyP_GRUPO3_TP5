package ar.edu.unju.fi.pcyp.pto2;

import java.util.concurrent.Semaphore;

public class ContadorCompartido {
	 private int h = 0;
	    private final Semaphore mutex = new Semaphore(1);

	    public void incrementar(String nombreHilo) throws InterruptedException {
	        mutex.acquire();
	        h++;
	        System.out.println(nombreHilo + " sumó. h = " + h);
	        mutex.release();
	    }

	    public boolean intentarRestar(String nombreHilo) throws InterruptedException {
	        mutex.acquire();
	        if (h > 0) {
	            h--;
	            System.out.println(nombreHilo + " restó. h = " + h);
	            mutex.release();
	            return true; // Pudo restar con éxito
	        }
	        mutex.release();
	        return false; // No pudo restar porque h era 0
	    }

	    public int getValorFinal() {
	        return h;
	    }
}
