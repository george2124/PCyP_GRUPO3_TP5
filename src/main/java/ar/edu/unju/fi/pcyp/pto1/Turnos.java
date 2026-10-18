package ar.edu.unju.fi.pcyp.pto1;

import java.util.concurrent.Semaphore;

public class Turnos {
	private final Semaphore[] turnos;
	private final int totalComensales;
	
	public Turnos(int totalComensales) {
		this.totalComensales = totalComensales;
		this.turnos = new Semaphore[totalComensales];
		
		
		for (int i = 0; i < totalComensales; i++) {
            this.turnos[i] = new Semaphore(0);
        }
	}
		
		 public void esperarTurno(int numero) 
				 throws InterruptedException {
		        turnos[numero].acquire();
		    }
		 
		 // El comensal avisa que terminó y le cede el turno al siguiente
		 public void pasarTurno(int numero) {
		      int siguiente = (numero + 1) % totalComensales;
		      turnos[siguiente].release();
		 }
		 // Arranca el flujo dándole el primer permiso al comensal 0
		    public void habilitarPrimerComensal() {
		        turnos[0].release();
		    }
	
}
