
public class Principal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread hilo = Thread.currentThread(); // Capturando el hilo principal.
		System.out.println(hilo.toString()); // Mostramos información del hilo.
		Thread.sleep(1000); // Hacemos un retardo de un segundo.
		hilo.setPriority(3); // Cambiamos la prioridad del hilo.
		hilo.setName("HiloPrincipal"); // Cambiamos el nombre del hilo.
		System.out.println(hilo.toString()); // Mostramos información del hilo.

		
	}

}
