package ar.edu.unju.fi.pcyp.pto5;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		  // 1. Instanciamos la barbería compartida
        Barberia barberia = new Barberia();
        
        // 2. Encendemos el hilo del barbero que está adentro
        barberia.abrirBarberia();

        // 3. Lanzamos la tanda de clientes
        for (int i = 1; i <= 6; i++) {
            Cliente c = new Cliente(i, barberia);
            c.start();
            Thread.sleep(400); // Llegan espaciados en el tiempo
        }
        
        Thread.sleep(10000); // Esperamos para ver toda la simulación en pantalla
        System.out.println("Fin de la simulación de la Barbería.");
	}
}
