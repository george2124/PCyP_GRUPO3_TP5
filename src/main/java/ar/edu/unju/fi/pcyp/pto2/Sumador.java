package ar.edu.unju.fi.pcyp.pto2;


public class Sumador extends Thread {
	private final ContadorCompartido contador;
	private final int id;
	
	public Sumador(int id, ContadorCompartido contador) {
		super();
	this.contador = contador;
	this.id = id;
	}


	@Override
	public void run() {
	        for (int i = 0; i < 100; i++) {
	          	 try {
	                  contador.incrementar("Sumador-" + id);
                     Thread.sleep(10); // Pausa mínima para alternar los hilos
	          	 } catch (InterruptedException e) {
	                     Thread.currentThread().interrupt();
	               }
	         }
	  }
	   
}
