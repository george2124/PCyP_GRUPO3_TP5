package ar.edu.unju.fi.pcyp.pto5;

public class Cliente extends Thread{
	 private final int id;
	 private final Barberia b; // Referencia a la barbería compartida

	    public Cliente(int id, Barberia b) {
	        this.id = id;
	        this.b = b;
	    }

	    public void run() {
	        try {
	            b.mutexSillas.acquire(); // Mira las sillas de forma segura
	            if (b.sillasLibres > 0) {
	                b.sillasLibres--;
	                System.out.println("Cliente " + id + " se sentó en la sala de espera. Sillas libres: " + b.sillasLibres);
	                
	                b.clientes.release();  // Avisa al barbero
	                b.mutexSillas.release(); // Libera el acceso a las sillas
	                
	                b.barbero.acquire();   // Espera al barbero
	                System.out.println("Cliente " + id + " está siendo atendido.");
	            } else {
	                System.out.println("Cliente " + id + " vio la barbería llena y se retiró.");
	                b.mutexSillas.release(); // Libera el mutex antes de irse
	            }
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }

}
