
public class Corredor implements Runnable {
	private Thread hilo;

	
	 
	public Corredor(String nombre, int prioridad) {
			hilo = new Thread(this, nombre);
			hilo.setPriority(prioridad);
			hilo.start(); // Crea el hilo de ejecución y llama al método run()
	}


	@Override
	public void run() {
		for (int i=1; i<=10; i++) {
			System.out.println(hilo.getName() + " va por el kilómetro " + i);
			System.out.println(hilo.getName() + " ha llegado a la meta");
	}

	}
}
