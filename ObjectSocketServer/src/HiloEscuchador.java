import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HiloEscuchador implements Runnable {
	private Thread hilo;
	private static int numCliente = 0;
	private Socket enchufeAlCliente;
	private Escuela escuela;
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	
	public HiloEscuchador(Socket cliente, Escuela escuela) throws IOException {
		numCliente++;
		hilo = new Thread(this, "Cliente" + numCliente);
		this.enchufeAlCliente = cliente;
		this.escuela = escuela;
		hilo.start();
	}

	@Override
	public void run() {
		System.out.println("Estableciendo comunicación con " + hilo.getName());	
		try {		
			salida = new ObjectOutputStream(enchufeAlCliente.getOutputStream());
			entrada = new ObjectInputStream(enchufeAlCliente.getInputStream());
			String nif;
			do {
				nif = (String) entrada.readObject();
				if (nif.trim().equals("FIN")) {
					salida.writeObject("Hasta pronto, gracias por establecer conexión");
					System.out.println(hilo.getName() + " ha cerrado la comunicación");
				} else {
					System.out.println(hilo.getName() + " consulta el alumno: " + nif);
					// Enviamos el objeto correspondiente al alumno consultado.
					Alumno alu = escuela.getAlumnos().get(nif);
					
					if (alu==null) {
						salida.writeObject("Alumno no encontrado");	
					}
					else {
						salida.writeObject(alu);	
					}	
				}
			} while ((!nif.trim().equals("FIN")));
			entrada.close();
			salida.close();
			enchufeAlCliente.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
