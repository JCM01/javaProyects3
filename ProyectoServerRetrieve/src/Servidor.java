
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
	
	public static void main(String[] args) {
		ArrayList<Encuesta> encuestas = new ArrayList<Encuesta>();
		llenarEncuestas(encuestas);
		
		System.out.println("APLICACIÓN DE SERVIDOR ESTUDIO SOBRE CALIDAD");
		System.out.println("-------------------------------------------------");
		try {
			//Esto es el metodo donde se espera la conexion de los clientes para recibir sus peticiones.
			ServerSocket servidor = new ServerSocket();
			InetSocketAddress direccion = new InetSocketAddress("192.168.34.41", 2000);
			servidor.bind(direccion);// Es la vinculacion con el servidor de la ip con el InetSocketAddress.
			System.out.println("Dirección IP: " + direccion.getAddress());
			while (true) {
				Socket enchufeAlCliente = servidor.accept();// Aqui es donde se detiene la transmision hasta que el cliente acepte la conexion.
				System.out.println("Comunicación entrante");
				new HiloEscuchador(enchufeAlCliente, encuestas);// El hiloEscuchado nos ayuda atender muchas peticiones con los clientes.
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void llenarEncuestas(ArrayList<Encuesta> encuestas) {
		// Genera 10 encuestas al azar para cada provincia.
		// Nos permite tener datos de prueba.
		for (int provincia=1; provincia<=52; provincia++) {
			for (int i=1; i<=10; i++) {
				int so = (int) (Math.random()*8+1);
				int im = (int) (Math.random()*9+1);
				int us = (int) (Math.random()*10+1);
				encuestas.add(new Encuesta(provincia, so, im, us));
			}			
		}
	}
}
