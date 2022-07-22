import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketCliente {
	private static ObjectInputStream entrada;
	private static ObjectOutputStream salida;
	
	public static void main(String[] args) {
		System.out.println(" APLICACIÓN CLIENTE");
		System.out.println("-----------------------------------");
		Scanner lector = new Scanner(System.in);
		try {
			Socket cliente = new Socket();
			InetSocketAddress direccionServidor = new InetSocketAddress("192.168.1.102", 2000);
			System.out.println("Esperando a que el servidor acepte la conexión");
			cliente.connect(direccionServidor);
			// Conectamos con el servidor.
			System.out.println("Comunicación establecida con el servidor");
			
			salida = new ObjectOutputStream(cliente.getOutputStream());
			entrada = new ObjectInputStream(cliente.getInputStream());
			
			String nif = "";
			while (!nif.equals("FIN")) {
				System.out.println("Nif del alumno a consultar (FIN para terminar): ");
				nif = lector.nextLine();
				// Envio consulta al servidor.
				salida.writeObject(nif);
				// Recibo respuesta del servidor.
				Object alu = entrada.readObject();
				if (alu instanceof String) {
					System.out.println(alu);
					if (nif.equals("FIN")) break;
				}
				else {
					Alumno alumno = (Alumno) alu;
					System.out.println("Nombre alumno: " + alumno.getNombre());
					System.out.println("Edad: " + alumno.getEdad());
					for (Calificacion c : alumno.getCalificaciones()) {
						System.out.println(c.toString());
					}
				}
			}
			entrada.close();
			salida.close();
			cliente.close();
			System.out.println("Comunicación cerrada");
		} catch (UnknownHostException e) {
			System.out.println("No se puede establecer comunicación con el servidor");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("Error de E/S");
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		lector.close();
	}
}