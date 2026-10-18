package ar.edu.unju.fi.pcyp.pto2;


import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PcypTp5Grupo3Application {
	
	public static void main(String[] args) throws InterruptedException {
		ContadorCompartido contador = new ContadorCompartido();
		
		 Thread[] sumadores = new Thread[5];
	     Thread[] restadores = new Thread[5];

	        for (int i = 0; i < 5; i++) {
	            sumadores[i] = new Sumador(i + 1, contador);
	            restadores[i] = new Restador(i + 1, contador);
	            sumadores[i].start();
	            restadores[i].start();
	        }

	        for (int i = 0; i < 5; i++) {
	            sumadores[i].join();
	            restadores[i].join();
	        }

	        System.out.println("---------------------------------------------");
	        System.out.println("Valor final de h (nunca fue negativo): " + contador.getValorFinal());
	    }
	}
  
