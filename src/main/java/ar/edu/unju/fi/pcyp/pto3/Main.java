package ar.edu.unju.fi.pcyp.pto3;

public class Main {
	  public static void main(String[] args) throws InterruptedException {
	        Thread[] hilos = new Thread[10];

	        // Crear y lanzar hilos para las tablas del 1 al 10
	        for (int i = 0; i < 10; i++) {
	            hilos[i] = new CalculadorTabla(i + 1);
	            hilos[i].start();
	        }

	        // El hilo principal espera a que terminen todos antes de despedirse
	        for (int i = 0; i < 10; i++) {
	            hilos[i].join();
	        }

	        System.out.println("El hilo principal finalizó: Todas las tablas fueron mostradas.");
	    }
}
