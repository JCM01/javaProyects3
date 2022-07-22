import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketCliente {
	public static void main(String[] args) {
		System.out.println(" APLICACI�N CLIENTE");
		System.out.println("-----------------------------------");
		Scanner lector = new Scanner(System.in);
		try {
			Socket cliente = new Socket();
			InetSocketAddress direccionServidor = new InetSocketAddress("192.168.34.45", 2000);
			System.out.println("Esperando a que el servidor acepte la conexi�n");
			cliente.connect(direccionServidor);
			System.out.println("Comunicaci�n establecida con el servidor");
			InputStream entrada = cliente.getInputStream();
			OutputStream salida = cliente.getOutputStream();
			String texto = "";
			while (!texto.equals("FIN")) {
				System.out.println("Escribe mensaje (FIN para terminar): ");
				texto = lector.nextLine();
				salida.write(texto.getBytes());
				byte[] mensaje = new byte[100];
				entrada.read(mensaje);
				System.out.println("Servidor responde: " + new String(mensaje));
			}
			entrada.close();
			salida.close();
			cliente.close();
			System.out.println("Comunicaci�n cerrada");
		} catch (UnknownHostException e) {
			System.out.println("No se puede establecer comunicaci�n con el servidor");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("Error de E/S");
			System.out.println(e.getMessage());
		}
		lector.close();
	}
}
