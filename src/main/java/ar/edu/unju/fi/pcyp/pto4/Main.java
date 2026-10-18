package ar.edu.unju.fi.pcyp.pto4;

import java.util.concurrent.Semaphore;

public class Main {
	
	public static void main(String[] arg) throws InterruptedException {
		// Creamos el semáforo único inicializado en cero aquí
        Semaphore semaforo = new Semaphore(0);

        // Creamos los procesos pasándoles el semáforo común
        ProcesoR r = new ProcesoR(semaforo);
        ProcesoS s = new ProcesoS(semaforo);

        // Arrancamos los hilos
        s.start();
        r.start();

        // Esperamos a que finalicen
        s.join();
        r.join();

        System.out.println("Ambos procesos finalizaron.");
    }
	
	
}
