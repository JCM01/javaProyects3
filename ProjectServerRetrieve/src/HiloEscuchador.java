import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class HiloEscuchador implements Runnable {
	private Thread hilo;
	private static int numCliente = 0;
	private Socket enchufeAlCliente;
	private ArrayList<Encuesta> encuestas;
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	
	public HiloEscuchador(Socket cliente, ArrayList<Encuesta> encuestas) throws IOException {
		numCliente++;
		hilo = new Thread(this, "Cliente" + numCliente);
		this.enchufeAlCliente = cliente;
		this.encuestas = encuestas;
		hilo.start();
	}

	@Override
	public void run() {
		System.out.println("Estableciendo comunicación con " + hilo.getName());	
		try {		
			salida = new ObjectOutputStream(enchufeAlCliente.getOutputStream());
			entrada = new ObjectInputStream(enchufeAlCliente.getInputStream());
			salida.writeObject(encuestas);
			entrada.close();
			salida.close();
			enchufeAlCliente.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
