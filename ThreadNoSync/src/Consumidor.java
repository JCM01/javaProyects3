public class Consumidor implements Runnable {
	private Thread hilo;
	private BufferFrases buffer;
	private static int contador = 0;

	public Consumidor(BufferFrases buffer) {
		contador++;
		hilo = new Thread(this, "Consumidor" + contador);
		this.buffer = buffer;
		hilo.start();
	}

	@Override
	public void run() {
		String frase = buffer.sacar();
		if (frase != null) {
			System.out.println(frase);
		} else {
			System.out.println("Cola vacía");
		}

	}
}
