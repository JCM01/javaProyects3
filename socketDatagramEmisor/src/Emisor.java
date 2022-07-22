import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Emisor {
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		try {
			DatagramSocket ds = new DatagramSocket();
			
			InetAddress destino = InetAddress.getByName("192.168.1.102");
			// Dirección IP del receptor
			
			String mensaje = "";
			while (!mensaje.equals("FIN")) {
				System.out.println("Escribe un mensaje: ");
				mensaje = lector.nextLine();
				int lon = mensaje.length();
				DatagramPacket paquete = new DatagramPacket
(mensaje.getBytes(), lon, destino, 5000);
				// Argumentos: mensaje en bytes, longitud mensaje, InetAddress del receptor, puerto
				
				ds.send(paquete);
				// Enviamos el paquete a través del DatagramSocket
				
				System.out.println("Enviado");
			}
			ds.close();
			// Cerramos el socket Datagram.
			System.out.println("Socket Datagram cerrado");
		} catch (SocketException | UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		lector.close();
	}
}

