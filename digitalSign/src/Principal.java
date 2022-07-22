import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Scanner;

import javax.crypto.Cipher;

public class Principal {

	public static void main(String[] args) {
		Firma mf;
		try {
			FileInputStream fichero = new FileInputStream("firma.obj");
			ObjectInputStream buffer = new ObjectInputStream(fichero);
			mf = (Firma) buffer.readObject();
			buffer.close();
			fichero.close();
		} catch (Exception e) {
			System.out.println("Error al leer fichero de firma digital");
			System.out.println("Excepción de tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
			return;
		}
		Scanner lector = new Scanner(System.in);
		try {
			Signature firmadorVerificador = Signature.getInstance("SHA1withRSA");
			firmadorVerificador.initVerify(mf.getClavePublica());
			
			System.out.println("¿Cuál es el mensaje secreto?");
			String mensajeSecreto = lector.nextLine();
			firmadorVerificador.update(mensajeSecreto.getBytes());
			boolean ok = firmadorVerificador.verify(mf.getFirma());
			if (ok) {
				System.out.println("OK, Bienvenido al sistema de generación de mensajes");
				crearMensajeCifrado(mf.getClavePublica(), lector);
			} else {
				System.out.println("Lo siento, no tienes acceso al sistema de generación de mensajes");
			}
			lector.close();
			
		} catch (GeneralSecurityException e) {
			System.out.println("Error en la verificación de la firma digital");
			System.out.println("Excepción de tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
			lector.close();
			return;
		}

	}
	private static void crearMensajeCifrado(PublicKey clavePublica, Scanner lector) {
		ArrayList<byte[]> mensajes = new ArrayList<byte[]>(); 
		
		System.out.println("Escribe un mensaje: ");
		String mensaje = lector.nextLine();
		mensajes.add(mensaje.getBytes());
		
		System.out.println("Escribe un mensaje: ");
		mensaje = lector.nextLine();
		mensajes.add(mensaje.getBytes());
		
		System.out.println("Escribe un mensaje: ");
		mensaje = lector.nextLine();
		mensajes.add(mensaje.getBytes());
		
		System.out.println("Escribe un mensaje: ");
		mensaje = lector.nextLine();
		mensajes.add(mensaje.getBytes());
	
		try {
			Cipher cifrador = Cipher.getInstance("RSA");
			cifrador.init(Cipher.ENCRYPT_MODE, clavePublica);
			
			mensajes.set(0, cifrador.doFinal(mensajes.get(0)));
			mensajes.set(1, cifrador.doFinal(mensajes.get(1)));
			
			mensajes.set(2, cifrador.doFinal(mensajes.get(2)));
			mensajes.set(3, cifrador.doFinal(mensajes.get(3)));
		
			FileOutputStream fichero = new FileOutputStream("mensajes.dat");
			
			ObjectOutputStream buffer = new ObjectOutputStream(fichero);
			
			buffer.writeObject(mensajes);
			buffer.close();
			fichero.close();
			
		} catch (Exception e) {
			System.out.println("Error al grabar el fichero mensajes.dat");
			System.out.println("Excepción de tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
		}
	}

}
