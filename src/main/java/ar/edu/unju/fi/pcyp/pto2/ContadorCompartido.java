package ar.edu.unju.fi.pcyp.pto2;

import java.util.concurrent.Semaphore;

public class ContadorCompartido {
	 private int h = 0;
	 
	 	//para la exclusion mutua(mutex). 
	 	//Graciasa Semaforo binario inicializado en 1 es posible la sincronizacion 
	 
	    private final Semaphore mutex = new Semaphore(1);

	    public void incrementar(String nombreHilo) throws InterruptedException {
	        mutex.acquire();//entra a seccion critica
	        h++;
	        System.out.println(nombreHilo + " sumó. h = " + h);
	        mutex.release();//sale de seccion critica
	    }

	    public boolean intentarRestar(String nombreHilo) throws InterruptedException {
	        mutex.acquire();//entra a seccion critica
	        if (h > 0) { //aca la condicion para h no sea negativa
	            h--;
	            System.out.println(nombreHilo + " restó. h = " + h);
	            mutex.release();//sale de seccion critica
	            return true; // Pudo restar con éxito
	        }
	        mutex.release();
	        return false; // No pudo restar porque h era 0
	    }

	    public int getValorFinal() {
	        return h;
	    }
}
