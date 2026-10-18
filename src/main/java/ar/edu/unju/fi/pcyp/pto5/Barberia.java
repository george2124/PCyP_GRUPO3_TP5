package ar.edu.unju.fi.pcyp.pto5;

import java.util.concurrent.Semaphore;

public class Barberia {
	private final int N_SILLAS = 3;
	public int sillasLibres = N_SILLAS;
	
	 // Semáforos accesibles para los clientes
    public final Semaphore mutexSillas = new Semaphore(1); 
    public final Semaphore clientes = new Semaphore(0);    
    public final Semaphore barbero = new Semaphore(0);  
    
    public void abrirBarberia() {
        Barbero b = new Barbero();
        b.setDaemon(true); // Permite terminar el programa aunque esté en ciclo infinito
        b.start();
    }
    
    // El Barbero vive adentro de la Barbería como una clase interna
    private class Barbero extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    clientes.acquire(); // Se duerme si no hay clientes
                    
                    mutexSillas.acquire();
                    sillasLibres++;      // Libera una silla de espera antes de atender
                    barbero.release();   // Le avisa al cliente que está listo
                    mutexSillas.release();

                    // Simula el corte de pelo
                    System.out.println("El Barbero está cortando el pelo...");
                    Thread.sleep(1500);
                    System.out.println("El Barbero terminó el corte.");
                    
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
