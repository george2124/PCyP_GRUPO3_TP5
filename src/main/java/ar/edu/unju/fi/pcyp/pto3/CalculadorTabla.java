package ar.edu.unju.fi.pcyp.pto3;

public class CalculadorTabla extends Thread{
	 private final int numeroTabla;
	 private static final Object cerrojoImpresion = new Object();
	 
     public CalculadorTabla(int numeroTabla) {
         this.numeroTabla = numeroTabla;
     }

     public void run() {
         // El cálculo y la impresión completa de la tabla se sincronizan
         synchronized (cerrojoImpresion) {
             System.out.println("--- TABLA DEL " + numeroTabla + " ---");
             for (int i = 1; i <= 10; i++) {
                 System.out.println(numeroTabla + " x " + i + " = " + (numeroTabla * i));
             }
             System.out.println();
         }
     }
}
