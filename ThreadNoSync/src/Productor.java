public class Productor implements Runnable {
	private static int contador = 0;
	private BufferFrases buffer;
	private Thread hilo;

	public Productor(BufferFrases buffer) {
		contador++;
		this.buffer = buffer;
		hilo = new Thread(this, "Productor" + contador);
		hilo.start();
	}

	@Override
	public void run() {
		buffer.poner();
	}
}
