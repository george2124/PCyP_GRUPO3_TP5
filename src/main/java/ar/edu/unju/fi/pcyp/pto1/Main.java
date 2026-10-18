package ar.edu.unju.fi.pcyp.pto1;



public class Main {
	
	public static void main(String[] args) throws InterruptedException{
		int cantidadComensales = 5;	
		
		// Crear el administrador de turnos
        Turnos gestor = new Turnos(cantidadComensales);

        // Habilitar el inicio de la cadena (Comensal 1 / índice 0)
        gestor.habilitarPrimerComensal();

        Comensales[] comensales = new Comensales[cantidadComensales];

        // Crear y arrancar los cinco hilos pasándoles el gestor común
        for (int i = 0; i < cantidadComensales; i++) {
            comensales[i] = new Comensales(i, gestor);
            comensales[i].start();
        }

        // Esperar a que todos terminen
        for (int i = 0; i < cantidadComensales; i++) {
            comensales[i].join();
        }

        System.out.println("Todos los comensales terminaron.");
    }
}
