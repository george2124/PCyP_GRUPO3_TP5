package ar.edu.unju.fi.pcyp.pto1;


public class Comensales extends Thread{
	
	private final int numero;
	private final Turnos gestor;

	public Comensales(int numero, Turnos gestor) {
		super();
		this.numero = numero;
		this.gestor = gestor; 
	}
	public void run() {
			
			try {
				gestor.esperarTurno(numero);
				System.out.println( "Comensal " + (numero + 1) + "Comienza a servirse");
				
				Thread.sleep(1000);
				
				System.out.println( "Comensal" + (numero + 1) + "termino de servirse");
				
				int siguiente = (numero + 1) % 5;
				gestor.pasarTurno(siguiente);
				
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
	}
}
	
	
	

