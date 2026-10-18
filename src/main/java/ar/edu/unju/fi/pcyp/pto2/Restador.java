package ar.edu.unju.fi.pcyp.pto2;


public class Restador extends Thread {
	private final ContadorCompartido contador;
	private final int id;
	
	public Restador(int id, ContadorCompartido contador) {
		super();
		this.contador = contador;
		this.id = id;
	}
	
	@Override
	public void run() {
        for (int i = 0; i < 100; i++) {
        	try {
                // Intenta restar. Si no puede (porque h es 0), vuelve a intentar.
                if (!contador.intentarRestar("Restador-" + id)) {
                    i--; // Reintenta la iteración
                }
                Thread.sleep(10); // Pausa mínima para evitar congelamiento de CPU
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
