
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
public class Servidor {
	public static void main(String[] args) {
		System.out.println(" APLICACI�N DE SERVIDOR ");
		System.out.println("----------------------------------");
		try {
			ServerSocket servidor = new ServerSocket();
			InetSocketAddress direccion = new InetSocketAddress("192.168.34.41", 2000);
			servidor.bind(direccion);
 // Vinculamos el servidor con la direcci�n establecida por el objeto InetSocketAddress
 System.out.println("Servidor creado y escuchando .... ");
 System.out.println("Direcci�n IP: " + direccion.getAddress());
 Socket enchufeAlCliente = servidor.accept();
 // Detiene el proceso hasta que un cliente solicite una conexi�n.
 System.out.println("Comunicaci�n entrante");
 InputStream entrada = enchufeAlCliente.getInputStream();
 OutputStream salida = enchufeAlCliente.getOutputStream();
// Abrirmos los flujos de entrada y salida para las comunicaciones.
 String texto = "";
 while (!texto.trim().equals("FIN")) {
	 byte[] mensaje = new byte[100];
	 entrada.read(mensaje);
	 // Lee mensaje del cliente (array de bytes) texto = new String(mensaje); if (texto.trim().equals("FIN")) { salida.write("Hasta pronto, gracias por establecer conexi�n".getBytes()); } else {
	 String[] array = texto.split("-");
	 String peso = array[0]; String altura = array[1];
	 float pesoCliente = Float.parseFloat(peso);
	 float alturaCliente = Float.parseFloat(altura);
	 float alturaMultiplicado = alturaCliente*alturaCliente;
	 float imc = pesoCliente/alturaMultiplicado;
	 if (imc < 18.5) {
		 salida.write(("Tu IMC es: " +imc+ " Rango de peso insuficiente (<18,5)").getBytes());
	 } else if (imc >= 18.5 && imc <= 24.9) {
		 salida.write(("Tu IMC es: " +imc+ " Rango de Normopeso (18,5-24,9)").getBytes());
	 } else if (imc >= 25 && imc <= 26.9) {

	salida.write(("Tu IMC es: " +imc+ " Rango de Sobrepeso (25-29,9)").getBytes());
	 }
	 else if (imc >= 27 && imc <= 29.9) {
		 salida.write(("Tu IMC es: " +imc+ " Rango de Obesidad (>30) ").getBytes());
	 }
	
	 else {
		 salida.write(("Tu IMC es: " +imc+ " Situaci�n de extrema obesidad").getBytes());
	 }
 	}
 entrada.close();
	salida.close();
	enchufeAlCliente.close();
	servidor.close();
	System.out.println("Comunicaci�n cerrada");
		} catch (IOException e) { System.out.println(e.getMessage());
	}
	}
}

